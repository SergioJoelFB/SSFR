package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Clases.Conexion;
import Clases.Eventos;
import Clases.Invitado;
import Clases.Registro;

public class menuAdmin {

	private JFrame frame;

	private ButtonGroup grupo;

	private JButton a1, b, c, d, r, q;

	private JLabel ce;

	private int buscar_idEvento;

	private int buscar_idInvitado;

	private String extraer_nombre_evento;

	private String sacar_nombre_del_evento_del_panel_evento;

	private Invitado inv;

	int cantidad;

	public static Boolean entro = false;

	int res;

	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;
	private JTextField n_text;
	private JTextField t_text;
	private JTextField nom_bre;
	private JTextField ape_llido;
	private JTextField direc;
	private JTextField ema;
	private JTextField tel_fono;
	private JTextField id_ev;
	private JTextField id_invitado;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panelMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuAdmin window = new menuAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menuAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1060, 685);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		grupo = new ButtonGroup();

		JPanel panelAdmin = new JPanel();
		panelAdmin.setForeground(new Color(255, 153, 0));
		panelAdmin.setBackground(new Color(0, 0, 0));
		panelAdmin.setBounds(0, 0, 1066, 685);
		frame.getContentPane().add(panelAdmin);

		if (entro.equals(false)) {
			panelAdmin.setVisible(false);
		} else if (entro.equals(true)) {
			panelAdmin.setVisible(true);
		}

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 1066, 74);

		panelTitulo.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent ev) {
				x = ev.getX();
				y = ev.getY();
			}

		});
		panelTitulo.addMouseMotionListener(new MouseMotionAdapter() {

			private int x;
			private int y;

			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen() - this.x;
				int y = evt.getYOnScreen() - this.y;
				frame.setLocation(x, y);

			}
		});
		panelAdmin.setLayout(null);
		panelTitulo.setBackground(new Color(51, 51, 51));
		panelAdmin.add(panelTitulo);
		panelTitulo.setLayout(null);

		Image repo = new ImageIcon(this.getClass().getResource("/repo.png")).getImage();
		Image bv1 = new ImageIcon(this.getClass().getResource("/bv.png")).getImage();
		Image sw = new ImageIcon(this.getClass().getResource("/show.png")).getImage();
		Image x_ev = new ImageIcon(this.getClass().getResource("/x_ev.png")).getImage();
		Image ic = new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		
		JLabel lblModoAdmin = new JLabel("Modo Admin");
		lblModoAdmin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Registro_Login rl = new Registro_Login();
				rl.main(null);
				frame.setVisible(false);
				
			}
		});
		lblModoAdmin.setForeground(new Color(255, 153, 0));
		lblModoAdmin.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblModoAdmin.setBounds(909, 17, 114, 40);
		panelTitulo.add(lblModoAdmin);

		JLabel lblBienvenido = new JLabel("SSFR");
		lblBienvenido.setBounds(492, 17, 81, 43);
		panelTitulo.add(lblBienvenido);
		lblBienvenido.setForeground(new Color(255, 153, 0));
		lblBienvenido.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));

		JLabel salir = new JLabel("X");
		salir.setBackground(new Color(51, 0, 51));
		salir.setForeground(new Color(255, 153, 0));
		salir.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		salir.setFont(new Font("Century Gothic", Font.BOLD, 18));
		salir.setBounds(1044, 0, 12, 31);
		panelTitulo.add(salir);

		panelMenu = new JPanel();
		panelMenu.setBounds(-309, 74, 374, 611);
		panelAdmin.add(panelMenu);
		panelMenu.setBackground(new Color(102, 102, 102));
		panelMenu.setForeground(new Color(102, 102, 102));
		panelMenu.setLayout(null);

		JLabel menu = new JLabel("=");
		menu.setForeground(new Color(255, 153, 0));
		menu.setBackground(new Color(255, 153, 0));
		menu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				actividadOff();

				d.setVisible(false);

				if (menu.getText().equals("=")) {

					for (int a = -314; a <= 0; a++) {
						panelMenu.setBounds(a, 74, 374, 611);

						menu.setText("<");

					}
					
					try {
						eventosHoy();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					table.setVisible(true);

					scrollPane.setVisible(true);
			
				} else if (menu.getText().equals("<")) {

					for (int a = 0; a >= -314; a--) {
						panelMenu.setBounds(a, 74, 374, 611);
						menu.setText("=");
					}

					try {
						eventosHoy();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					table.setVisible(true);

					scrollPane.setVisible(true);

					actividadOn();
					visibilidadOn();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		menu.setBounds(0, 0, 71, 63);
		panelTitulo.add(menu);
		menu.setFont(new Font("Tahoma", Font.PLAIN, 97));

		JPanel regEvento = new JPanel();
		regEvento.setBackground(Color.BLACK);
		regEvento.setVisible(false);
		regEvento.setBounds(298, 106, 470, 525);
		panelAdmin.add(regEvento);
		regEvento.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 470, 75);
		regEvento.add(panel);
		panel.setLayout(null);

		JPanel reg_inv = new JPanel();
		reg_inv.setBounds(253, 144, 553, 530);
		panelAdmin.add(reg_inv);
		reg_inv.setVisible(false);
		reg_inv.setRequestFocusEnabled(false);
		reg_inv.setBackground(Color.BLACK);
		reg_inv.setLayout(null);

		JLabel lblIngresaLosDatos = new JLabel("Ingresa los Datos");
		lblIngresaLosDatos.setBounds(105, 16, 259, 43);
		panel.add(lblIngresaLosDatos);
		lblIngresaLosDatos.setForeground(new Color(255, 153, 0));
		lblIngresaLosDatos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 470, 75);
		panel.add(panel_3);

		JLabel label_2 = new JLabel("Ingresa los Datos");
		label_2.setForeground(new Color(255, 153, 0));
		label_2.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_2.setBounds(105, 16, 259, 43);
		panel_3.add(label_2);

		JLabel lblNombreDelEvento = new JLabel("Nombre del Evento");
		lblNombreDelEvento.setForeground(new Color(255, 153, 0));
		lblNombreDelEvento.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNombreDelEvento.setBounds(10, 146, 201, 43);
		regEvento.add(lblNombreDelEvento);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(221, 185, 227, 2);
		regEvento.add(separator_6);

		JLabel lblDescripcion = new JLabel("Ubicacion");
		lblDescripcion.setForeground(new Color(255, 153, 0));
		lblDescripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblDescripcion.setBounds(10, 301, 103, 43);
		regEvento.add(lblDescripcion);

		JLabel lblFechaDelEvento = new JLabel("Fecha del Evento");
		lblFechaDelEvento.setForeground(new Color(255, 153, 0));
		lblFechaDelEvento.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblFechaDelEvento.setBounds(10, 200, 169, 43);
		regEvento.add(lblFechaDelEvento);

		JLabel labelTipEv = new JLabel("Tipo de evento");
		labelTipEv.setVisible(false);
		labelTipEv.setForeground(new Color(255, 153, 0));
		labelTipEv.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		labelTipEv.setBounds(10, 254, 169, 43);
		regEvento.add(labelTipEv);

		JSeparator sep = new JSeparator();
		sep.setVisible(false);
		sep.setEnabled(false);
		sep.setBounds(221, 293, 227, 2);
		regEvento.add(sep);

		t_text = new JTextField();
		t_text.setVisible(false);
		t_text.setForeground(Color.ORANGE);
		t_text.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		t_text.setBackground(Color.BLACK);
		t_text.setBorder(null);
		t_text.setColumns(10);
		t_text.setBounds(221, 266, 227, 20);
		regEvento.add(t_text);

		b = new JButton("Cumpleaños");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				labelTipEv.setVisible(false);

				sep.setVisible(false);

				t_text.setVisible(false);
				
				regEvento.setVisible(true);

				setClick(b.getText());

				visibilidadOff();

			}
		});
		b.setBounds(122, 440, 228, 161);
		Image icono1 = new ImageIcon(this.getClass().getResource("/cumpleanos.png")).getImage();
		b.setIcon(new ImageIcon(icono1));
		panelAdmin.add(b);

		c = new JButton("Velatorio");
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				labelTipEv.setVisible(false);

				sep.setVisible(false);

				t_text.setVisible(false);
				
				regEvento.setVisible(true);

				setClick(c.getText());

				visibilidadOff();

			}
		});
		c.setBounds(689, 228, 228, 161);
		Image icono2 = new ImageIcon(this.getClass().getResource("/velatorio.png")).getImage();
		c.setIcon(new ImageIcon(icono2));
		panelAdmin.add(c);

		d = new JButton("Boda");
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				labelTipEv.setVisible(false);

				sep.setVisible(false);

				t_text.setVisible(false);
				
				regEvento.setVisible(true);

				setClick(d.getText());

				visibilidadOff();

			}
		});
		Image boda = new ImageIcon(this.getClass().getResource("/boda.png")).getImage();
		d.setIcon(new ImageIcon(boda));
		d.setBounds(122, 228, 228, 161);
		panelAdmin.add(d);

		q = new JButton("Personalizado");
		q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				regEvento.setVisible(true);

				labelTipEv.setVisible(true);

				sep.setVisible(true);

				t_text.setVisible(true);

				visibilidadOff();

			}
		});
		Image per = new ImageIcon(this.getClass().getResource("/cruz.png")).getImage();
		q.setBorder(null);
		q.setIcon(new ImageIcon(per));
		q.setBounds(707, 433, 228, 175);
		panelAdmin.add(q);

		ce = new JLabel("Crea el evento de tu preferencia!!");
		ce.setForeground(new Color(255, 153, 0));
		ce.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		ce.setBounds(284, 100, 495, 43);
		panelAdmin.add(ce);

		r = new JButton("Cumplea\u00F1os");
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				labelTipEv.setVisible(false);

				sep.setVisible(false);

				t_text.setVisible(false);
				
				regEvento.setVisible(true);

				setClick(r.getText());

				visibilidadOff();

			}
		});
		r.setBounds(407, 443, 233, 154);
		Image w = new ImageIcon(this.getClass().getResource("/quinciañera.png")).getImage();
		r.setIcon(new ImageIcon(w));
		panelAdmin.add(r);

		a1 = new JButton("Aniversario");
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				regEvento.setVisible(true);

				setClick(a1.getText());

				visibilidadOff();

			}
		});
		a1.setBounds(406, 228, 228, 161);
		Image icono = new ImageIcon(this.getClass().getResource("/aniversario.png")).getImage();
		a1.setIcon(new ImageIcon(icono));
		panelAdmin.add(a1);

		JCheckBox dat_cor = new JCheckBox("Los Datos son correctos ");
		dat_cor.setFont(new Font("Segoe UI", Font.BOLD, 13));
		dat_cor.setForeground(Color.ORANGE);
		dat_cor.setBackground(Color.BLACK);
		dat_cor.setBounds(147, 373, 177, 23);
		regEvento.add(dat_cor);

		n_text = new JTextField();
		n_text.setForeground(Color.ORANGE);
		n_text.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		n_text.setBackground(Color.BLACK);
		n_text.setBorder(null);
		n_text.setBounds(221, 158, 227, 20);
		regEvento.add(n_text);
		n_text.setColumns(10);

		JTextArea u_text = new JTextArea();
		u_text.setForeground(Color.ORANGE);
		u_text.setFont(new Font("Monospaced", Font.PLAIN, 16));
		u_text.setBackground(new Color(0, 51, 51));
		u_text.setBounds(221, 311, 227, 55);
		regEvento.add(u_text);

		JDateChooser dc = new JDateChooser();
		dc.setDateFormatString("MMMM dd, yyyy");
		dc.setBounds(221, 210, 227, 20);
		regEvento.add(dc);

		id_ev = new JTextField();
		id_ev.setForeground(Color.ORANGE);
		id_ev.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		id_ev.setColumns(10);
		id_ev.setBorder(null);
		id_ev.setBackground(Color.BLACK);
		id_ev.setBounds(221, 106, 227, 20);
		regEvento.add(id_ev);

		JButton aderir = new JButton("");
		aderir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dia = dc.getCalendar().get(Calendar.DAY_OF_WEEK) - 2;
				int mes = dc.getCalendar().get(Calendar.MONTH) + 1;
				int yr = dc.getCalendar().get(Calendar.YEAR);

				int id_evn = Integer.valueOf(id_ev.getText());

				setBuscar_idEvento(id_evn);

				String n_ev = n_text.getText();

				String f_ev = " " + dia + "/" + mes + "/" + yr + " ";

				String u_ev = u_text.getText();

				setClick(t_text.getText());

				String t_ev = getClick();

				if (dat_cor.isSelected()) {

					if (!n_text.getText().trim().equals("") || dc.getDateFormatString() != ""
							|| u_text.getText() != "") {

						Registro reg = new Registro();

						setClic(n_ev);

						Eventos eventos = new Eventos(id_evn, n_ev, f_ev, u_ev, t_ev);

						reg.registrarEvento(eventos, t_ev);

						n_text.setText("");
						u_text.setText("");
						t_text.setText("");
						id_ev.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "No debe dejar NADA vacio");
						n_text.setText("");
						u_text.setText("");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar el 'Los datos son correctos' ");
				}

			}

		});
		aderir.setBackground(new Color(0, 0, 0));
		aderir.setBorder(null);
		Image i = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		aderir.setIcon(new ImageIcon(i));
		aderir.setBounds(282, 408, 119, 62);
		regEvento.add(aderir);

		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				regEvento.setVisible(false);
				n_text.setText("");
				u_text.setText("");
				visibilidadOn();
			}
		});
		back.setBorder(null);
		Image g = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		back.setIcon(new ImageIcon(g));
		back.setBackground(Color.BLACK);
		back.setBounds(58, 408, 119, 62);
		regEvento.add(back);

		JLabel lblMantenimientoUsuarios = new JLabel("Actualizacion");
		lblMantenimientoUsuarios.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Actualizaciones act = new Actualizaciones();

				act.main(null);
				act.setEntro(true);

				frame.setVisible(false);
			}
		});
		lblMantenimientoUsuarios.setForeground(Color.WHITE);
		lblMantenimientoUsuarios.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblMantenimientoUsuarios.setBounds(10, 23, 183, 21);
		panelMenu.add(lblMantenimientoUsuarios);

		JLabel lblReportes = new JLabel("Reportes");
		lblReportes.setForeground(Color.WHITE);
		lblReportes.addMouseListener(new MouseListener() {

			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Reportes rep = new Reportes();
				rep.main(null);
				frame.setVisible(false);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		lblReportes.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblReportes.setBounds(10, 60, 183, 45);
		panelMenu.add(lblReportes);

		JLabel lblBuscar = new JLabel("Buscar Visitantes");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				BuscarVisitantes bv = new BuscarVisitantes();
				bv.main(null);
				bv.setEntro(true);
				frame.setVisible(false);
			}
		});
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblBuscar.setBounds(10, 119, 256, 31);
		panelMenu.add(lblBuscar);

		JLabel lblMostrar = new JLabel("Mostrar Invitados");
		lblMostrar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {

				MostrarInvitados mi = new MostrarInvitados();

				mi.main(null);

				mi.setEntro(true);

				frame.setVisible(false);
			}
		});
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblMostrar.setBounds(10, 165, 183, 31);
		panelMenu.add(lblMostrar);

		JLabel lblDesplegarProximo = new JLabel("Listado de Proximos Eventos");
		lblDesplegarProximo.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ProximosEventos pe = new ProximosEventos();
				pe.main(null);
				pe.setEntro(true);
				frame.setVisible(false);

			}
		});
		lblDesplegarProximo.setForeground(Color.WHITE);
		lblDesplegarProximo.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblDesplegarProximo.setBounds(8, 207, 304, 45);
		panelMenu.add(lblDesplegarProximo);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 55, 462, 2);
		panelMenu.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 105, 462, 2);
		panelMenu.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 151, 462, 2);
		panelMenu.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 202, 462, 2);
		panelMenu.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 252, 374, 2);
		panelMenu.add(separator_5);

		JLabel rep = new JLabel("skdjvnksd");
		rep.setIcon(new ImageIcon(repo));
		rep.setBounds(317, 55, 46, 50);
		panelMenu.add(rep);

		JLabel bv = new JLabel("skdjvnksd");
		bv.setIcon(new ImageIcon(bv1));
		bv.setBounds(320, 110, 46, 43);
		panelMenu.add(bv);

		JLabel show = new JLabel("skdjvnksd");
		show.setIcon(new ImageIcon(sw));
		show.setBounds(317, 151, 46, 48);
		panelMenu.add(show);

		JLabel nx_ev = new JLabel("skdjvnksd");
		nx_ev.setIcon(new ImageIcon(x_ev));
		nx_ev.setBounds(320, 205, 48, 48);
		panelMenu.add(nx_ev);

		JLabel act = new JLabel("act");
		act.setIcon(new ImageIcon(ic));
		act.setBounds(315, 11, 46, 43);
		panelMenu.add(act);

		JLabel lblInvitadosPorLlegar = new JLabel("Invitados Por Llegar");
		lblInvitadosPorLlegar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				InvitadosPorllegar ip = new InvitadosPorllegar();
				ip.main(null);
				ip.setEntro(true);
				frame.setVisible(false);

			}
		});
		lblInvitadosPorLlegar.setForeground(Color.WHITE);
		lblInvitadosPorLlegar.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblInvitadosPorLlegar.setBounds(10, 252, 304, 45);
		panelMenu.add(lblInvitadosPorLlegar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 299, 462, 2);
		panelMenu.add(separator);

		JLabel label_4 = new JLabel("skdjvnksd");
		Image ic19 = new ImageIcon(this.getClass().getResource("/falta.png")).getImage();
		label_4.setIcon(new ImageIcon(ic19));
		label_4.setBounds(312, 253, 57, 48);
		panelMenu.add(label_4);

		JLabel label = new JLabel("Eventos Actuales");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		label.setBounds(10, 302, 304, 45);
		panelMenu.add(label);

		JLabel label_3 = new JLabel("skdjvnksd");
		Image ev_act = new ImageIcon(this.getClass().getResource("/evn.png")).getImage();
		label_3.setIcon(new ImageIcon(ev_act));
		label_3.setBounds(317, 303, 48, 48);
		panelMenu.add(label_3);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(0, 598, 374, 2);
		panelMenu.add(separator_10);

		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(10, 372, 354, 79);
		panelMenu.add(scrollPane);

		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(159, 274, 46, 14);
		panelAdmin.add(label_1);

		JButton btnDeseaHacerUna = new JButton("Desea Hacer una Invitacion?");
		btnDeseaHacerUna.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDeseaHacerUna.setForeground(Color.ORANGE);
		btnDeseaHacerUna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reg_inv.setVisible(true);

				frame.setBackground(Color.BLACK);

				regEvento.setVisible(false);

				visibilidadOff();

				actividadOff();
			}
		});
		btnDeseaHacerUna.setBorder(null);
		btnDeseaHacerUna.setBackground(Color.BLACK);
		btnDeseaHacerUna.setBounds(147, 471, 175, 43);
		regEvento.add(btnDeseaHacerUna);

		JLabel lblId = new JLabel("id");
		lblId.setForeground(new Color(255, 153, 0));
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblId.setBounds(10, 92, 201, 43);
		regEvento.add(lblId);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(221, 133, 227, 2);
		regEvento.add(separator_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 588, 75);
		reg_inv.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);

		JLabel lblIngreseLosInvitados = new JLabel("Ingrese los Invitados");
		lblIngreseLosInvitados.setForeground(new Color(255, 153, 0));
		lblIngreseLosInvitados.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblIngreseLosInvitados.setBounds(127, 16, 333, 43);
		panel_2.add(lblIngreseLosInvitados);

		JLabel lblNombre = new JLabel(" Nombre ");
		lblNombre.setForeground(new Color(255, 153, 0));
		lblNombre.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNombre.setBounds(53, 176, 116, 43);
		reg_inv.add(lblNombre);

		JLabel restan = new JLabel("");
		restan.setForeground(new Color(255, 153, 0));
		restan.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		restan.setBounds(459, 87, 65, 43);
		reg_inv.add(restan);

		JSpinner spin = new JSpinner();
		spin.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				cantidad = (int) spin.getValue();

				restan.setText("" + cantidad);

				res = cantidad--;

			}

		});
		spin.setBounds(309, 102, 65, 20);
		reg_inv.add(spin);

		nom_bre = new JTextField();
		nom_bre.setForeground(Color.ORANGE);
		nom_bre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nom_bre.setColumns(10);
		nom_bre.setBorder(null);
		nom_bre.setBackground(Color.BLACK);
		nom_bre.setBounds(214, 188, 281, 20);
		reg_inv.add(nom_bre);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(214, 210, 281, 2);
		reg_inv.add(separator_11);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(new Color(255, 153, 0));
		lblApellidos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblApellidos.setBounds(53, 218, 116, 43);
		reg_inv.add(lblApellidos);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(214, 252, 281, 2);
		reg_inv.add(separator_12);

		JLabel lblTelefono = new JLabel(" Telefono");
		lblTelefono.setForeground(new Color(255, 153, 0));
		lblTelefono.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTelefono.setBounds(53, 262, 116, 43);
		reg_inv.add(lblTelefono);

		JLabel lblDireccion = new JLabel(" Direccion");
		lblDireccion.setForeground(new Color(255, 153, 0));
		lblDireccion.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblDireccion.setBounds(53, 305, 116, 43);
		reg_inv.add(lblDireccion);

		JLabel lblSexo = new JLabel(" Sexo");
		lblSexo.setForeground(new Color(255, 153, 0));
		lblSexo.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblSexo.setBounds(52, 408, 116, 43);
		reg_inv.add(lblSexo);

		ape_llido = new JTextField();
		ape_llido.setForeground(Color.ORANGE);
		ape_llido.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ape_llido.setColumns(10);
		ape_llido.setBorder(null);
		ape_llido.setBackground(Color.BLACK);
		ape_llido.setBounds(214, 230, 281, 20);
		reg_inv.add(ape_llido);

		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(214, 299, 281, 2);
		reg_inv.add(separator_13);

		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(214, 340, 281, 2);
		reg_inv.add(separator_14);

		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(214, 383, 281, 2);
		reg_inv.add(separator_15);

		JLabel lblEmail = new JLabel(" Email");
		lblEmail.setForeground(new Color(255, 153, 0));
		lblEmail.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblEmail.setBounds(53, 354, 116, 43);
		reg_inv.add(lblEmail);

		direc = new JTextField();
		direc.setForeground(Color.ORANGE);
		direc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		direc.setColumns(10);
		direc.setBorder(null);
		direc.setBackground(Color.BLACK);
		direc.setBounds(214, 317, 281, 20);
		reg_inv.add(direc);

		ema = new JTextField();
		ema.setForeground(Color.ORANGE);
		ema.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ema.setColumns(10);
		ema.setBorder(null);
		ema.setBackground(Color.BLACK);
		ema.setBounds(214, 358, 281, 20);
		reg_inv.add(ema);

		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setForeground(Color.ORANGE);
		rdbtnF.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		rdbtnF.setBorder(null);
		rdbtnF.setBackground(Color.DARK_GRAY);
		rdbtnF.setBounds(244, 424, 109, 23);
		reg_inv.add(rdbtnF);

		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setForeground(Color.ORANGE);
		rdbtnM.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		rdbtnM.setBorder(null);
		rdbtnM.setBackground(Color.DARK_GRAY);
		rdbtnM.setBounds(367, 424, 109, 23);
		reg_inv.add(rdbtnM);

		grupo.add(rdbtnM);
		grupo.add(rdbtnF);

		id_invitado = new JTextField();
		id_invitado.setForeground(Color.ORANGE);
		id_invitado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		id_invitado.setColumns(10);
		id_invitado.setBorder(null);
		id_invitado.setBackground(Color.BLACK);
		id_invitado.setBounds(214, 146, 281, 20);
		reg_inv.add(id_invitado);

		JButton btnGuardar = new JButton("");
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				res = cantidad--;

				do {

					int id_invi = Integer.valueOf(id_invitado.getText());
					String n = nom_bre.getText();
					String a = ape_llido.getText();
					String tel = tel_fono.getText();
					String d = direc.getText();
					String sex = null;

					setBuscar_idInvitado(id_invi);

					int id_Evento = getBuscar_idEvento();
					int id_Invitado = getBuscar_idInvitado();

					if (rdbtnF.isSelected()) {
						sex = rdbtnF.getText();
					} else if (rdbtnM.isSelected()) {
						sex = rdbtnM.getText();
					}

					String sx = sex;

					String email = ema.getText();

					inv = new Invitado(id_invi, n, a, tel, d, sx, email);

					String tip_evento = getClick();

					String nombre_evento = getClic();

					Registro reg = new Registro();

					reg.registrarInvitacion(id_Invitado, id_Evento);

					reg.registrarInvitado(inv, sx, nombre_evento, tip_evento);

					JOptionPane.showMessageDialog(null, "Invitado No." + res + "Agregado");

					nom_bre.setText("");
					ape_llido.setText("");
					direc.setText("");
					tel_fono.setText("");
					ema.setText("");

					restan.setText("" + res);

					if (res == 0) {
						JOptionPane.showMessageDialog(null, "Todos los invitados registrados");
						reg_inv.setVisible(false);
						regEvento.setVisible(true);
					}

				} while (res < cantidad);

			}
		});
		btnGuardar.setBounds(336, 457, 119, 62);
		btnGuardar.setIcon(new ImageIcon(i));
		reg_inv.add(btnGuardar);

		tel_fono = new JTextField();
		tel_fono.setForeground(Color.ORANGE);
		tel_fono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tel_fono.setColumns(10);
		tel_fono.setBorder(null);
		tel_fono.setBackground(Color.BLACK);
		tel_fono.setBounds(214, 277, 281, 20);
		reg_inv.add(tel_fono);

		JButton atras = new JButton("");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				nom_bre.setText("");
				ape_llido.setText("");
				direc.setText("");
				tel_fono.setText("");
				ema.setText("");

				reg_inv.setVisible(false);
				panelAdmin.setVisible(true);

				frame.setBackground(Color.BLACK);

				actividadOn();
				visibilidadOn();
			}
		});
		atras.setBorder(null);
		atras.setBackground(Color.BLACK);
		atras.setIcon(new ImageIcon(g));
		atras.setBounds(104, 457, 119, 62);
		reg_inv.add(atras);

		JLabel lblCantidadDeInvitados = new JLabel("Cantidad de Invitados");
		lblCantidadDeInvitados.setForeground(new Color(255, 153, 0));
		lblCantidadDeInvitados.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblCantidadDeInvitados.setBounds(52, 88, 192, 43);
		reg_inv.add(lblCantidadDeInvitados);

		JLabel labelId = new JLabel("Id");
		labelId.setForeground(new Color(255, 153, 0));
		labelId.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		labelId.setBounds(53, 134, 116, 43);
		reg_inv.add(labelId);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(214, 168, 281, 2);
		reg_inv.add(separator_8);
		
		JLabel lblDesarrolladoPor = new JLabel("Desarrollado por Sergio Joel Ferreras & Sarah Ramos - Matriculas: 2016-3837 - 2016-3605");
		lblDesarrolladoPor.setBounds(249, 642, 568, 43);
		panelAdmin.add(lblDesarrolladoPor);
		lblDesarrolladoPor.setForeground(new Color(255, 153, 0));
		lblDesarrolladoPor.setFont(new Font("Segoe UI Black", Font.BOLD, 11));

		grupo = new ButtonGroup();

	}

	public void eventosHoy() throws ClassNotFoundException {

		try {
			
			boolean existe = false;

			Conexion con = new Conexion();
			Statement st = con.conectar().createStatement();

			Calendar now = Calendar.getInstance();

			int dia = now.get(Calendar.DAY_OF_WEEK) - 2;
			int mes = now.get(Calendar.MONTH) + 1;
			int yr = now.get(Calendar.YEAR);

			String f_ev = " " + dia + "/" + mes + "/" + yr;

			String sql = "SELECT * FROM eventos where fecha = '" + f_ev + "'";

			ResultSet rs = st.executeQuery(sql);

			String presentacion[] = { "Id", "Nombre", "Tipo de evento", "Descripcion", "Fecha" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5) };

				forma.addRow(datos);

				table.setModel(forma);
				
				existe = true;
			}
			
			if(existe != true) {
				
				JLabel noExiste = new JLabel("No existen Eventos programados para el dia de hoy!!");
				noExiste.setForeground(Color.WHITE);
				noExiste.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
				noExiste.setBounds(29, 494, 316, 45);
				panelMenu.add(noExiste);
				
				JLabel noExiste1 = new JLabel("Por favor pasa por la seccion de proximos eventos y selecciona una fecha!");
				noExiste1.setForeground(Color.WHITE);
				noExiste1.setFont(new Font("Rockwell Condensed", Font.BOLD, 10));
				noExiste1.setBounds(38, 542, 297, 45);
				panelMenu.add(noExiste1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean isEntro() {
		return entro;
	}

	public static void setEntro(boolean entro) {
		menuAdmin.entro = entro;
	}

	public void visibilidadOff() {

		a1.setVisible(false);
		b.setVisible(false);
		c.setVisible(false);
		d.setVisible(false);
		q.setVisible(false);
		r.setVisible(false);
		ce.setVisible(false);

	}

	public void visibilidadOn() {

		a1.setVisible(true);
		b.setVisible(true);
		c.setVisible(true);
		d.setVisible(true);
		q.setVisible(true);
		r.setVisible(true);
		ce.setVisible(true);

	}

	public void actividadOff() {

		a1.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		q.setEnabled(false);
		r.setEnabled(false);
		ce.setEnabled(false);

	}

	public void actividadOn() {

		a1.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
		d.setEnabled(true);
		q.setEnabled(true);
		r.setEnabled(true);
		ce.setEnabled(true);

	}

	public String getClick() {
		return extraer_nombre_evento;
	}

	public void setClick(String click) {
		this.extraer_nombre_evento = click;
	}

	public String getClic() {
		return sacar_nombre_del_evento_del_panel_evento;
	}

	public void setClic(String clic) {
		this.sacar_nombre_del_evento_del_panel_evento = clic;
	}

	public int getBuscar_idEvento() {
		return buscar_idEvento;
	}

	public void setBuscar_idEvento(int buscar_idEvento) {
		this.buscar_idEvento = buscar_idEvento;
	}

	public int getBuscar_idInvitado() {
		return buscar_idInvitado;
	}

	public void setBuscar_idInvitado(int buscar_idInvitado) {
		this.buscar_idInvitado = buscar_idInvitado;
	}
}
