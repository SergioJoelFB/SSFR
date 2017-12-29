package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Clases.Eventos;
import Clases.Mantenimiento;
import Clases.Portero;

@SuppressWarnings("serial")
public class Actualizaciones extends JFrame {

	private JPanel contentPane;
	private JTable tabla_eventos;
	private JTextField n_ev;
	private JTextField t_ev;
	private JTextField f_ev;
	private JButton guardar, editar, borrar, btnInvitaciones, btnInvitados, btnEventos, btnUsuarios;
	private JTextField nom_invitado;
	private JTextField ap_invitado;
	private JTextField tel_invitado;
	private JTextField dir_invitado;
	private JTextField nom_invitaciones;
	private JTextField tip_invitaciones;
	private JTable table_invitaciones;
	private JTextField idEvento_text;
	private JTextField email_Invitado;
	private JTextField id_Invitados_text;
	private JTextField id_invitaciones;
	private JTextField ap_usuario;
	private JTextField us_usuario;
	private JTextField con_usuario;
	private JTextField nom_usuario;
	private JTable tabla_usuario;
	private JTable tabla_invitados;
	private JPanel panelInvitaciones;
	private JPanel panelnvitados;
	private JPanel panelEventos;
	private JPanel panelUsuarios;
	private int asistio;
	Mantenimiento a = new Mantenimiento();
	private JTextField id_usuario;
	
	public static Boolean entro = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actualizaciones frame = new Actualizaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Actualizaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image ic = new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		Image ic16 = new ImageIcon(this.getClass().getResource("/borrar.png")).getImage();
		Image ic19 = new ImageIcon(this.getClass().getResource("/editar.png")).getImage();
		Image ic15 = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		Image ic7 = new ImageIcon(this.getClass().getResource("/invi.png")).getImage();
		Image ic8 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		Image ic1 = new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		Image ic10 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		Image ic11 = new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		Image ic12 = new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		Image ic14 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		Image ic9 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		Image ic2 = new ImageIcon(this.getClass().getResource("/save.png")).getImage();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 688, 748);
		contentPane.add(panel);
		panel.setLayout(null);

		panelEventos = new JPanel();
		llenarTablaEventos();
		panelEventos.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 688, 59);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 688, 59);
		panel_1.add(panel_2);

		JLabel icono = new JLabel("");
		icono.setBounds(137, 11, 48, 43);
		panel_2.add(icono);
		icono.setIcon(new ImageIcon(ic1));
		icono.setForeground(new Color(255, 153, 0));
		icono.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!isEntro()) {
					menuPortero.main(null);
					setVisible(false);
				} else if (isEntro()) {
					setVisible(false);
					menuAdmin.main(null);
					menuAdmin.setEntro(true);
				}
		
			}
		});
		label_2.setForeground(new Color(255, 153, 0));
		label_2.setIcon(new ImageIcon(ic10));
		label_2.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_2.setBounds(10, 11, 48, 43);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Actualizaciones");
		label_3.setForeground(new Color(255, 153, 0));
		label_3.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_3.setBounds(220, 11, 256, 43);
		panel_2.add(label_3);
		panelEventos.setBackground(new Color(0, 0, 0));
		panelEventos.setBounds(88, 70, 491, 594);
		panel.add(panelEventos);
		panelEventos.setLayout(null);

		JTextArea u_ev = new JTextArea();
		u_ev.setForeground(new Color(255, 153, 0));
		u_ev.setBackground(new Color(51, 51, 51));
		u_ev.setBounds(254, 238, 227, 70);
		panelEventos.add(u_ev);

		panelnvitados = new JPanel();
		panelnvitados.setVisible(false);
		llenarTablaInvitados();
		panelnvitados.setBounds(70, 60, 524, 570);
		panel.add(panelnvitados);
		panelnvitados.setBackground(new Color(0, 0, 0));
		panelnvitados.setLayout(null);

		panelInvitaciones = new JPanel();
		llenarTablaInvitaciones();
		panelInvitaciones.setVisible(false);
		panelInvitaciones.setBackground(Color.BLACK);
		panelInvitaciones.setBounds(80, 71, 493, 628);
		panelInvitaciones.setLayout(null);
		panel.add(panelInvitaciones);

		panelUsuarios = new JPanel();
		panelUsuarios.setVisible(false);
		llenarTablaUs();
		panelUsuarios.setBackground(Color.BLACK);
		panelUsuarios.setBounds(80, 91, 492, 539);
		panel.add(panelUsuarios);
		panelUsuarios.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 491, 59);
		panelEventos.add(panel_3);

		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setForeground(new Color(255, 153, 0));
		lblEventos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblEventos.setBounds(186, 11, 118, 43);
		panel_3.add(lblEventos);

		JLabel label_5 = new JLabel("");
		label_5.setForeground(new Color(255, 153, 0));
		label_5.setIcon(new ImageIcon(ic));
		label_5.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_5.setBounds(106, 11, 48, 43);
		panel_3.add(label_5);

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelEventos.setVisible(false);

				panel.setVisible(true);

				n_ev.setText("");

				t_ev.setText("");

				f_ev.setText("");

				u_ev.setText("");

				visibilidadOn();

			}
		});
		label_4.setForeground(new Color(255, 153, 0));
		label_4.setIcon(new ImageIcon(ic8));
		label_4.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_4.setBounds(10, 11, 48, 43);
		panel_3.add(label_4);

		JLabel label_13 = new JLabel("ID ");
		label_13.setBounds(-12, 55, 130, 48);
		panel_3.add(label_13);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lblNombreDelEvento = new JLabel("Nombre del Evento");
		lblNombreDelEvento.setForeground(new Color(255, 255, 255));
		lblNombreDelEvento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNombreDelEvento.setBounds(10, 100, 130, 48);
		panelEventos.add(lblNombreDelEvento);

		n_ev = new JTextField();
		n_ev.setBackground(new Color(0, 0, 0));
		n_ev.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		n_ev.setForeground(new Color(255, 153, 0));
		n_ev.setBorder(null);
		n_ev.setBounds(254, 116, 227, 20);
		panelEventos.add(n_ev);
		n_ev.setColumns(10);

		JLabel lblTipoDeEvento = new JLabel("Tipo de Evento");
		lblTipoDeEvento.setForeground(Color.WHITE);
		lblTipoDeEvento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTipoDeEvento.setBounds(10, 147, 130, 48);
		panelEventos.add(lblTipoDeEvento);

		t_ev = new JTextField();
		t_ev.setBackground(new Color(0, 0, 0));
		t_ev.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		t_ev.setForeground(new Color(255, 153, 0));
		t_ev.setBorder(null);
		t_ev.setColumns(10);
		t_ev.setBounds(254, 163, 227, 20);
		panelEventos.add(t_ev);

		JLabel Fecha = new JLabel("Fecha");
		Fecha.setForeground(Color.WHITE);
		Fecha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Fecha.setBounds(10, 191, 130, 48);
		panelEventos.add(Fecha);

		f_ev = new JTextField();
		f_ev.setBackground(new Color(0, 0, 0));
		f_ev.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		f_ev.setForeground(new Color(255, 153, 0));
		f_ev.setBorder(null);
		f_ev.setColumns(10);
		f_ev.setBounds(254, 207, 227, 20);
		panelEventos.add(f_ev);

		btnInvitados = new JButton("Invitados");
		btnInvitados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnvitados.setVisible(true);
				visibilidadOff();
			}
		});
		btnInvitados.setForeground(new Color(255, 153, 0));
		btnInvitados.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 25));
		btnInvitados.setBorder(null);
		btnInvitados.setIcon(new ImageIcon(ic11));
		btnInvitados.setBackground(Color.BLACK);
		btnInvitados.setBounds(389, 253, 227, 85);
		panel.add(btnInvitados);

		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setForeground(Color.WHITE);
		lblUbicacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUbicacion.setBounds(10, 238, 130, 48);
		panelEventos.add(lblUbicacion);

		JSeparator separator = new JSeparator();
		separator.setBounds(254, 139, 227, 1);
		panelEventos.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(254, 185, 227, 1);
		panelEventos.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(254, 231, 227, 1);
		panelEventos.add(separator_2);

		guardar = new JButton("");
		guardar.setBorder(null);
		guardar.setBackground(new Color(0, 0, 0));
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.valueOf( idEvento_text.getText());
				String nom = n_ev.getText();
				String tipo = t_ev.getText();
				String ubi = u_ev.getText();
				String fecha = f_ev.getText();
				
				Eventos p = new Eventos(id, nom, ubi, tipo, fecha);

				a.guardareventos(p);
				
				llenarTablaEventos();
			}
		});
		guardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		guardar.setIcon(new ImageIcon(ic2));
		guardar.setBounds(341, 513, 140, 48);
		panelEventos.add(guardar);

		editar = new JButton("");
		editar.setBorder(null);
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		editar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Image ic3 = new ImageIcon(this.getClass().getResource("/editar.png")).getImage();
		editar.setIcon(new ImageIcon(ic3));
		editar.setBackground(Color.BLACK);
		editar.setBounds(176, 505, 140, 66);
		panelEventos.add(editar);

		borrar = new JButton("");
		borrar.setBorder(null);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image ic4 = new ImageIcon(this.getClass().getResource("/borrar.png")).getImage();
		borrar.setIcon(new ImageIcon(ic4));
		borrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrar.setBackground(Color.BLACK);
		borrar.setBounds(20, 513, 140, 58);
		panelEventos.add(borrar);

		JLabel lblId = new JLabel("ID ");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId.setBounds(10, 58, 130, 48);
		panelEventos.add(lblId);

		idEvento_text = new JTextField();
		idEvento_text.setForeground(new Color(255, 153, 0));
		idEvento_text.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		idEvento_text.setColumns(10);
		idEvento_text.setBorder(null);
		idEvento_text.setBackground(Color.BLACK);
		idEvento_text.setBounds(254, 81, 227, 20);
		panelEventos.add(idEvento_text);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(254, 104, 227, 1);
		panelEventos.add(separator_10);

		JLabel lblActualizaciones = new JLabel(" Que desea actualizar?");
		lblActualizaciones.setBounds(203, 134, 281, 35);
		lblActualizaciones.setForeground(new Color(255, 153, 0));
		lblActualizaciones.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 29));
		panel.add(lblActualizaciones);

		btnEventos = new JButton("Eventos");
		btnEventos.setForeground(new Color(255, 153, 0));
		btnEventos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 25));
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEventos.setVisible(true);
				visibilidadOff();
			}
		});
		Image ic6 = new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		btnEventos.setIcon(new ImageIcon(ic6));
		btnEventos.setBorder(null);
		btnEventos.setBackground(Color.BLACK);
		btnEventos.setBounds(55, 253, 227, 85);
		panel.add(btnEventos);

		btnUsuarios = new JButton(" Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelUsuarios.setVisible(true);

				visibilidadOff();
			}
		});
		btnUsuarios.setForeground(new Color(255, 153, 0));
		btnUsuarios.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 25));
		btnUsuarios.setBorder(null);
		btnUsuarios.setIcon(new ImageIcon(ic9));
		btnUsuarios.setBackground(Color.BLACK);
		btnUsuarios.setBounds(389, 379, 227, 85);
		panel.add(btnUsuarios);

		btnInvitaciones = new JButton(" Invitaciones");
		btnInvitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInvitaciones.setVisible(true);
				visibilidadOff();				
			}
		});
		btnInvitaciones.setForeground(new Color(255, 153, 0));

		btnInvitaciones.setIcon(new ImageIcon(ic7));
		btnInvitaciones.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 25));
		btnInvitaciones.setBorder(null);
		btnInvitaciones.setBackground(Color.BLACK);
		btnInvitaciones.setBounds(55, 379, 227, 85);
		panel.add(btnInvitaciones);

		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_1.setBounds(10, 70, 48, 43);
		panel.add(label_1);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNombre.setBounds(21, 126, 130, 48);
		panelnvitados.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblApellidos.setBounds(21, 173, 130, 48);
		panelnvitados.add(lblApellidos);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTelefono.setBounds(21, 217, 130, 48);
		panelnvitados.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDireccion.setBounds(21, 264, 130, 48);
		panelnvitados.add(lblDireccion);

		nom_invitado = new JTextField();
		nom_invitado.setForeground(new Color(255, 153, 0));
		nom_invitado.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		nom_invitado.setColumns(10);
		nom_invitado.setBorder(null);
		nom_invitado.setBackground(Color.BLACK);
		nom_invitado.setBounds(265, 142, 227, 20);
		panelnvitados.add(nom_invitado);

		ap_invitado = new JTextField();
		ap_invitado.setForeground(new Color(255, 153, 0));
		ap_invitado.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		ap_invitado.setColumns(10);
		ap_invitado.setBorder(null);
		ap_invitado.setBackground(Color.BLACK);
		ap_invitado.setBounds(265, 189, 227, 20);
		panelnvitados.add(ap_invitado);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(265, 165, 227, 1);
		panelnvitados.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(265, 211, 227, 1);
		panelnvitados.add(separator_4);

		tel_invitado = new JTextField();
		tel_invitado.setForeground(new Color(255, 153, 0));
		tel_invitado.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		tel_invitado.setColumns(10);
		tel_invitado.setBorder(null);
		tel_invitado.setBackground(Color.BLACK);
		tel_invitado.setBounds(265, 233, 227, 20);
		panelnvitados.add(tel_invitado);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(265, 257, 227, 1);
		panelnvitados.add(separator_5);

		JButton borrarInvitado = new JButton("");
		borrarInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		borrarInvitado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrarInvitado.setBorder(null);
		borrarInvitado.setIcon(new ImageIcon(ic16));
		borrarInvitado.setBackground(Color.BLACK);
		borrarInvitado.setBounds(20, 500, 140, 58);
		panelnvitados.add(borrarInvitado);

		JButton editarInvitado = new JButton("");
		editarInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nom = nom_invitado.getText();
				String ap = ap_invitado.getText();
				String ema = email_Invitado.getText();
				String tel = tel_invitado.getText();
				String id = id_Invitados_text.getText();
				String dir = dir_invitado.getText();
				
				a.modificarinvitados(nom, ap, tel, dir, ema, id);
				
				llenarTablaInvitados();
				
			}
		});
		editarInvitado.setIcon(new ImageIcon(ic19));
		editarInvitado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		editarInvitado.setBorder(null);
		editarInvitado.setBackground(Color.BLACK);
		editarInvitado.setBounds(192, 492, 140, 66);
		panelnvitados.add(editarInvitado);

		JButton guardarInvitado = new JButton("");
		guardarInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardarInvitado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		guardarInvitado.setBorder(null);
		guardarInvitado.setIcon(new ImageIcon(ic15));
		guardarInvitado.setBackground(Color.BLACK);
		guardarInvitado.setBounds(362, 500, 140, 58);
		panelnvitados.add(guardarInvitado);

		dir_invitado = new JTextField();
		dir_invitado.setForeground(new Color(255, 153, 0));
		dir_invitado.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		dir_invitado.setColumns(10);
		dir_invitado.setBorder(null);
		dir_invitado.setBackground(Color.BLACK);
		dir_invitado.setBounds(265, 269, 227, 20);
		panelnvitados.add(dir_invitado);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(265, 293, 227, 1);
		panelnvitados.add(separator_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 524, 73);
		panelnvitados.add(panel_4);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setLayout(null);

		JLabel lblInvitados = new JLabel("Invitados");
		lblInvitados.setBounds(191, 19, 142, 43);
		panel_4.add(lblInvitados);
		lblInvitados.setForeground(new Color(255, 153, 0));
		lblInvitados.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));

		JLabel label = new JLabel("");
		label.setForeground(new Color(255, 153, 0));
		label.setIcon(new ImageIcon(ic12));
		label.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label.setBounds(105, 19, 67, 43);
		panel_4.add(label);

		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelnvitados.setVisible(false);

				id_Invitados_text.setText("");

				nom_invitado.setText("");

				ap_invitado.setText("");

				dir_invitado.setText("");

				panel.setVisible(true);

				visibilidadOn();

			}
		});
		label_6.setIcon(new ImageIcon(ic14));
		label_6.setForeground(new Color(255, 153, 0));
		label_6.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_6.setBounds(10, 19, 67, 43);
		panel_4.add(label_6);

		JLabel Email = new JLabel("Email");
		Email.setForeground(Color.WHITE);
		Email.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Email.setBounds(21, 307, 130, 48);
		panelnvitados.add(Email);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(265, 336, 227, 1);
		panelnvitados.add(separator_11);

		email_Invitado = new JTextField();
		email_Invitado.setForeground(new Color(255, 153, 0));
		email_Invitado.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		email_Invitado.setColumns(10);
		email_Invitado.setBorder(null);
		email_Invitado.setBackground(Color.BLACK);
		email_Invitado.setBounds(265, 312, 227, 20);
		panelnvitados.add(email_Invitado);

		id_Invitados_text = new JTextField();
		id_Invitados_text.setForeground(new Color(255, 153, 0));
		id_Invitados_text.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		id_Invitados_text.setColumns(10);
		id_Invitados_text.setBorder(null);
		id_Invitados_text.setBackground(Color.BLACK);
		id_Invitados_text.setBounds(265, 99, 227, 20);
		panelnvitados.add(id_Invitados_text);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(265, 122, 227, 1);
		panelnvitados.add(separator_12);

		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId_1.setBounds(21, 83, 130, 48);
		panelnvitados.add(lblId_1);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(0, 0, 491, 59);
		panelInvitaciones.add(panel_6);

		JLabel lblInvitaciones = new JLabel("Invitaciones");
		lblInvitaciones.setForeground(new Color(255, 153, 0));
		lblInvitaciones.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblInvitaciones.setBounds(164, 11, 194, 43);
		panel_6.add(lblInvitaciones);

		JLabel label_8 = new JLabel("");
		label_8.setForeground(new Color(255, 153, 0));
		label_8.setIcon(new ImageIcon(ic7));
		label_8.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_8.setBounds(92, 0, 64, 59);
		panel_6.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelInvitaciones.setVisible(false);

				id_invitaciones.setText("");

				nom_invitaciones.setText("");

				tip_invitaciones.setText("");

				panel.setVisible(true);

				visibilidadOn();
			}
		});
		label_9.setForeground(new Color(255, 153, 0));
		label_9.setIcon(new ImageIcon(ic8));
		label_9.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_9.setBounds(10, 11, 48, 43);
		panel_6.add(label_9);

		JButton borrarInvitacion = new JButton("");
		borrarInvitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		borrarInvitacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrarInvitacion.setIcon(new ImageIcon(ic16));
		borrarInvitacion.setBorder(null);
		borrarInvitacion.setBackground(Color.BLACK);
		borrarInvitacion.setBounds(10, 545, 140, 58);
		panelInvitaciones.add(borrarInvitacion);

		JButton editarInvitacion = new JButton("");
		editarInvitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editarInvitacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		editarInvitacion.setIcon(new ImageIcon(ic19));
		editarInvitacion.setBorder(null);
		editarInvitacion.setBackground(Color.BLACK);
		editarInvitacion.setBounds(175, 545, 140, 66);
		panelInvitaciones.add(editarInvitacion);

		JButton guardarInvitacion = new JButton("");
		guardarInvitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardarInvitacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		guardarInvitacion.setBorder(null);
		guardarInvitacion.setIcon(new ImageIcon(ic15));
		guardarInvitacion.setBackground(Color.BLACK);
		guardarInvitacion.setBounds(343, 545, 140, 48);
		panelInvitaciones.add(guardarInvitacion);

		JLabel label_7 = new JLabel("Nombre del Evento");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_7.setBounds(10, 149, 130, 48);
		panelInvitaciones.add(label_7);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(254, 188, 227, 1);
		panelInvitaciones.add(separator_7);

		nom_invitaciones = new JTextField();
		nom_invitaciones.setForeground(new Color(255, 153, 0));
		nom_invitaciones.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		nom_invitaciones.setColumns(10);
		nom_invitaciones.setBorder(null);
		nom_invitaciones.setBackground(Color.BLACK);
		nom_invitaciones.setBounds(254, 165, 227, 20);
		panelInvitaciones.add(nom_invitaciones);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(254, 230, 227, 1);
		panelInvitaciones.add(separator_8);

		tip_invitaciones = new JTextField();
		tip_invitaciones.setForeground(new Color(255, 153, 0));
		tip_invitaciones.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		tip_invitaciones.setColumns(10);
		tip_invitaciones.setBorder(null);
		tip_invitaciones.setBackground(Color.BLACK);
		tip_invitaciones.setBounds(254, 208, 227, 20);
		panelInvitaciones.add(tip_invitaciones);

		JLabel label_10 = new JLabel("Tipo de Evento");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_10.setBounds(10, 192, 130, 48);
		panelInvitaciones.add(label_10);

		JLabel lblId_2 = new JLabel("ID");
		lblId_2.setForeground(Color.WHITE);
		lblId_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId_2.setBounds(10, 106, 130, 48);
		panelInvitaciones.add(lblId_2);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(254, 145, 227, 1);
		panelInvitaciones.add(separator_9);

		id_invitaciones = new JTextField();
		id_invitaciones.setForeground(new Color(255, 153, 0));
		id_invitaciones.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		id_invitaciones.setColumns(10);
		id_invitaciones.setBorder(null);
		id_invitaciones.setBackground(Color.BLACK);
		id_invitaciones.setBounds(254, 122, 227, 20);
		panelInvitaciones.add(id_invitaciones);

		JLabel lblAsistio = new JLabel("Asistio");
		lblAsistio.setForeground(Color.WHITE);
		lblAsistio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAsistio.setBounds(10, 251, 130, 48);
		panelInvitaciones.add(lblAsistio);

		JRadioButton asis = new JRadioButton("Asistio?");
		asis.setForeground(new Color(255, 200, 0));
		asis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (asis.isSelected()) {
					asistio = 1;
					setAsistio(asistio);
				} else if (!asis.isSelected()) {
					asistio = 0;
					setAsistio(asistio);
				}

			}

		});
		asis.setFont(new Font("Segoe UI", Font.BOLD, 15));
		asis.setBackground(Color.DARK_GRAY);
		asis.setBounds(254, 263, 109, 23);
		panelInvitaciones.add(asis);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(0, 0, 491, 59);
		panelUsuarios.add(panel_7);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setForeground(new Color(255, 153, 0));
		lblUsuarios.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblUsuarios.setBounds(180, 11, 130, 43);
		panel_7.add(lblUsuarios);

		JLabel label_12 = new JLabel("");
		label_12.setForeground(new Color(255, 153, 0));
		label_12.setIcon(new ImageIcon(ic9));
		label_12.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_12.setBounds(106, 2, 64, 54);
		panel_7.add(label_12);

		JLabel label_14 = new JLabel("");
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panelUsuarios.setVisible(false);

				nom_usuario.setText("");

				ap_usuario.setText("");

				us_usuario.setText("");

				con_usuario.setText("");

				panel.setVisible(true);

				visibilidadOn();
			}
		});
		label_14.setForeground(new Color(255, 153, 0));
		label_14.setIcon(new ImageIcon(ic8));
		label_14.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_14.setBounds(10, 11, 48, 43);
		panel_7.add(label_14);

		JLabel label_15 = new JLabel("ID ");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_15.setBounds(-12, 55, 130, 48);
		panel_7.add(label_15);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblApellido.setBounds(10, 146, 130, 48);
		panelUsuarios.add(lblApellido);

		ap_usuario = new JTextField();
		ap_usuario.setForeground(new Color(255, 153, 0));
		ap_usuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		ap_usuario.setColumns(10);
		ap_usuario.setBorder(null);
		ap_usuario.setBackground(Color.BLACK);
		ap_usuario.setBounds(254, 162, 227, 20);
		panelUsuarios.add(ap_usuario);

		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(254, 185, 227, 1);
		panelUsuarios.add(separator_13);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(10, 193, 130, 48);
		panelUsuarios.add(lblUsuario);

		us_usuario = new JTextField();
		us_usuario.setForeground(new Color(255, 153, 0));
		us_usuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		us_usuario.setColumns(10);
		us_usuario.setBorder(null);
		us_usuario.setBackground(Color.BLACK);
		us_usuario.setBounds(254, 209, 227, 20);
		panelUsuarios.add(us_usuario);

		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(254, 231, 227, 1);
		panelUsuarios.add(separator_14);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblContrasea.setBounds(10, 237, 130, 48);
		panelUsuarios.add(lblContrasea);

		con_usuario = new JPasswordField();
		con_usuario.setForeground(new Color(255, 153, 0));
		con_usuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		con_usuario.setColumns(10);
		con_usuario.setBorder(null);
		con_usuario.setBackground(Color.BLACK);
		con_usuario.setBounds(254, 253, 227, 20);
		panelUsuarios.add(con_usuario);

		nom_usuario = new JTextField();
		nom_usuario.setForeground(new Color(255, 153, 0));
		nom_usuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		nom_usuario.setColumns(10);
		nom_usuario.setBorder(null);
		nom_usuario.setBackground(Color.BLACK);
		nom_usuario.setBounds(254, 127, 227, 20);
		panelUsuarios.add(nom_usuario);

		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(254, 150, 227, 1);
		panelUsuarios.add(separator_15);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setForeground(Color.WHITE);
		lblNombre_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNombre_1.setBounds(10, 104, 130, 48);
		panelUsuarios.add(lblNombre_1);

		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(254, 277, 227, 1);
		panelUsuarios.add(separator_16);

		JButton borrar_usuario = new JButton("");
		borrar_usuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrar_usuario.setBorder(null);
		borrar_usuario.setIcon(new ImageIcon(ic16));
		borrar_usuario.setBackground(Color.BLACK);
		borrar_usuario.setBounds(20, 456, 140, 58);
		panelUsuarios.add(borrar_usuario);
		borrar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = id_usuario.getText();

				a.eliminarusuario(id);
				
				llenarTablaUs();
			}
		});

		JButton editar_usuario = new JButton("");
		editar_usuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		editar_usuario.setBorder(null);
		editar_usuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String tip_perfil = "Portero";
				
				String id = id_usuario.getText();
				String nom = nom_usuario.getText();
				String ap = ap_usuario.getText();
				String us = us_usuario.getText();
				String con = con_usuario.getText();
				
				Portero p = new Portero(nom, ap, us, con);
				
				a.modificarusuarios(p, tip_perfil, id);
				
				llenarTablaUs();
				
			}
			
		});
		editar_usuario.setBackground(Color.BLACK);
		editar_usuario.setIcon(new ImageIcon(ic19));
		editar_usuario.setBounds(176, 448, 140, 66);
		panelUsuarios.add(editar_usuario);

		JButton guardar_usuario = new JButton("");
		guardar_usuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		guardar_usuario.setBorder(null);
		guardar_usuario.setIcon(new ImageIcon(ic15));
		guardar_usuario.setBackground(Color.BLACK);
		guardar_usuario.setBounds(341, 456, 140, 48);
		panelUsuarios.add(guardar_usuario);
		
		JLabel lblId_3 = new JLabel("Id");
		lblId_3.setForeground(Color.WHITE);
		lblId_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId_3.setBounds(10, 70, 130, 48);
		panelUsuarios.add(lblId_3);
		
		id_usuario = new JTextField();
		id_usuario.setForeground(new Color(255, 153, 0));
		id_usuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		id_usuario.setColumns(10);
		id_usuario.setBorder(null);
		id_usuario.setBackground(Color.BLACK);
		id_usuario.setBounds(254, 93, 227, 20);
		panelUsuarios.add(id_usuario);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBounds(254, 116, 227, 1);
		panelUsuarios.add(separator_17);
		guardar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nom = nom_usuario.getText();
				String ap = ap_usuario.getText();
				String usuario = us_usuario.getText();
				String cont = String.valueOf(con_usuario.getText());

				Portero p = new Portero(nom, ap, usuario, cont);

				Mantenimiento a = new Mantenimiento();

				a.guardarusuarios(p);
				llenarTablaUs();
			}
		});

	}

	public int getAsistio() {
		return asistio;
	}

	public void setAsistio(int asistio) {
		this.asistio = asistio;
	}

	public void visibilidadOff() {

		btnEventos.setVisible(false);
		btnInvitaciones.setVisible(false);
		btnInvitados.setVisible(false);
		btnUsuarios.setVisible(false);

	}

	public void visibilidadOn() {

		btnEventos.setVisible(true);
		btnInvitados.setVisible(true);
		btnUsuarios.setVisible(true);
		btnInvitaciones.setVisible(true);

	}

	public void llenarTablaInvitaciones() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre, tipo_evento, asistio FROM invitados ev INNER JOIN invitaciones inv On inv.id_invitado = ev.id";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 325, 471, 165);
			panelInvitaciones.add(scrollPane);

			table_invitaciones = new JTable();
			leerinvitaciones(table_invitaciones);
			scrollPane.setViewportView(table_invitaciones);
			String presentacion[] = { "Nombre Invitado", "Evento al que asiste", "Asistio? 0 = no 1 = si" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				table_invitaciones.setModel(forma);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void llenarTablaUs() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT id, nombre, apellido, usuario FROM usuarios";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 296, 471, 131);
			panelUsuarios.add(scrollPane);

			tabla_usuario = new JTable();
			leerusuarios(tabla_usuario);
			scrollPane.setViewportView(tabla_usuario);

			String presentacion[] = { "Id", "Nombre", "Apellido", "Usuario" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4) };

				forma.addRow(datos);

				tabla_usuario.setModel(forma);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void llenarTablaInvitados() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT id, nombre, apellido, telefono, direccion, email FROM invitados";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 366, 478, 121);
			panelnvitados.add(scrollPane);

			tabla_invitados = new JTable();
			scrollPane.setViewportView(tabla_invitados);
			leerinvitados(tabla_invitados);

			String presentacion[] = { "id", "nombre", "apellido", "telefono", "direccion", "email" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) };

				forma.addRow(datos);

				tabla_invitados.setModel(forma);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		 

	}

	public void llenarTablaEventos() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT id, nombre, tipo_evento, fecha, ubicacion FROM eventos";
			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(3, 339, 478, 155);
			panelEventos.add(scrollPane);

			tabla_eventos = new JTable();
			tabla_eventos.setForeground(Color.ORANGE);
			tabla_eventos.setBackground(Color.BLACK);
			scrollPane.setViewportView(tabla_eventos);

			String presentacion[] = { "id", "nombre", "tipo_evento", "fecha", "Ubicacion" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5) };

				forma.addRow(datos);

				tabla_eventos.setModel(forma);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void limpiar() {

		idEvento_text.setText(null);
		n_ev.setText(null);
		t_ev.setText(null);
		f_ev.setText(null);

	}

	public void leerusuarios(JTable tabla) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (tabla.getSelectedRow() != -1) {
					nom_usuario.getText();
					int fila = tabla.getSelectedRow();
					id_usuario.setText(tabla.getValueAt(fila, 0).toString());
					nom_usuario.setText(tabla.getValueAt(fila, 1).toString());
					ap_usuario.setText(tabla.getValueAt(fila, 2).toString());
					us_usuario.setText(tabla.getValueAt(fila, 3).toString());
				}

			}

		});

	}
	
	public void leerinvitaciones(JTable tabla) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (tabla.getSelectedRow() != -1) {
					nom_invitaciones.getText();
					int fila = tabla.getSelectedRow();
					id_invitaciones.setText(tabla.getValueAt(fila, 0).toString());
					nom_invitaciones.setText(tabla.getValueAt(fila, 1).toString());
					tip_invitaciones.setText(tabla.getValueAt(fila, 2).toString());
				 
				}

			}

		});

	}
	public void leereventos(JTable tabla) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (tabla.getSelectedRow() != -1) {
					nom_usuario.getText();
					int fila = tabla.getSelectedRow();
					id_usuario.setText(tabla.getValueAt(fila, 0).toString());
					nom_usuario.setText(tabla.getValueAt(fila, 1).toString());
					ap_usuario.setText(tabla.getValueAt(fila, 2).toString());
					us_usuario.setText(tabla.getValueAt(fila, 3).toString());
				}

			}

		});

	}

	public void leerinvitados(JTable tabla) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (tabla.getSelectedRow() != -1) {
					nom_usuario.getText();
					int fila = tabla.getSelectedRow();
					nom_invitado.setText(tabla.getValueAt(fila, 1).toString());
					ap_invitado.setText(tabla.getValueAt(fila, 3).toString());
					email_Invitado.setText(tabla.getValueAt(fila, 2).toString());
					tel_invitado.setText(tabla.getValueAt(fila, 4).toString());
					id_Invitados_text.setText(tabla.getValueAt(fila, 0).toString());
					dir_invitado.setText(tabla.getValueAt(fila, 5).toString());
			
				}

			}

		});

	}
	
	public boolean isEntro() {
		return entro;
	}

	@SuppressWarnings("static-access")
	public  void setEntro(boolean entro) {
		this.entro = entro;
	}
	
}