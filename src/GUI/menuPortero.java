package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Conexion;

public class menuPortero {

	private JFrame frame;
	
	private String extraer_nombre_evento;

	private String sacar_nombre_del_evento_del_panel_evento;

	private JPanel panelPortero;

	int cantidad;

	public static Boolean entro = false;

	int res;

	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPortero window = new menuPortero();
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
	public menuPortero() {
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
		
		panelPortero = new JPanel();
		panelPortero.setBackground(Color.BLACK);
		panelPortero.setBounds(0, 0, 1060, 685);
		frame.getContentPane().add(panelPortero);
		panelPortero.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(-310, 74, 374, 611);
		panelMenu.setBackground(new Color(102, 102, 102));
		panelMenu.setForeground(new Color(102, 102, 102));
		panelMenu.setLayout(null);
		panelPortero.add(panelMenu);
		
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
		panelPortero.setLayout(null);
		panelTitulo.setBackground(new Color(51, 51, 51));
		panelPortero.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		new ImageIcon(this.getClass().getResource("/repo.png")).getImage();
		Image bv1 = new ImageIcon(this.getClass().getResource("/bv.png")).getImage();
		Image sw = new ImageIcon(this.getClass().getResource("/show.png")).getImage();
		Image x_ev = new ImageIcon(this.getClass().getResource("/x_ev.png")).getImage();
		new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		Image ic = new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		Image ev_act = new ImageIcon(this.getClass().getResource("/evn.png")).getImage();

		JLabel lblModoAdmin = new JLabel("Modo Portero");
		lblModoAdmin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro_Login rl = new Registro_Login();
				rl.main(null);
				frame.setVisible(false);
			}
		});
		lblModoAdmin.setForeground(new Color(255, 153, 0));
		lblModoAdmin.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblModoAdmin.setBounds(886, 17, 120, 40);
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
		
		JLabel label_3 = new JLabel("Buscar Visitantes");
		label_3.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				BuscarVisitantes bv = new BuscarVisitantes();
				bv.main(null);
				bv.setEntro(false);
				frame.setVisible(false);
			}
		});
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		label_3.setBounds(10, 65, 256, 31);
		panelMenu.add(label_3);
		
		JLabel lblMostrarInvitados = new JLabel("Mostrar Invitados");
		lblMostrarInvitados.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MostrarInvitados mi = new MostrarInvitados();
				
				mi.main(null);
				
				mi.setEntro(false);
				
				frame.setVisible(false);
				
			}
		});
		lblMostrarInvitados.setForeground(Color.WHITE);
		lblMostrarInvitados.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblMostrarInvitados.setBounds(10, 116, 183, 31);
		panelMenu.add(lblMostrarInvitados);
		
		JLabel label_5 = new JLabel("Listado de Proximos Eventos");
		label_5.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ProximosEventos pe = new ProximosEventos();
				pe.main(null);
				pe.setEntro(false);
				frame.setVisible(false);
				
			}
		});
		label_5.setForeground(Color.WHITE);
		
		label_5.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		label_5.setBounds(8, 158, 304, 45);
		panelMenu.add(label_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 56, 462, 2);
		panelMenu.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 102, 462, 2);
		panelMenu.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-13, 152, 462, 2);
		panelMenu.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 203, 374, 2);
		panelMenu.add(separator_4);

		JLabel bv = new JLabel("skdjvnksd");
		bv.setIcon(new ImageIcon(bv1));
		bv.setBounds(318, 62, 46, 43);
		panelMenu.add(bv);

		JLabel show = new JLabel("skdjvnksd");
		show.setIcon(new ImageIcon(sw));
		show.setBounds(315, 103, 46, 48);
		panelMenu.add(show);

		JLabel nx_ev = new JLabel("skdjvnksd");
		nx_ev.setIcon(new ImageIcon(x_ev));
		nx_ev.setBounds(318, 157, 48, 48);
		panelMenu.add(nx_ev);
		
		JLabel lblInvitadosPorLlegar = new JLabel("Invitados Por Llegar");
		lblInvitadosPorLlegar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				InvitadosPorllegar ip = new InvitadosPorllegar();
				ip.main(null);
				ip.setEntro(false);
				frame.setVisible(false);
			}
		});
		lblInvitadosPorLlegar.setForeground(Color.WHITE);
		lblInvitadosPorLlegar.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblInvitadosPorLlegar.setBounds(10, 210, 304, 45);
		panelMenu.add(lblInvitadosPorLlegar);
		
		JLabel label_13= new JLabel("skdjvnksd");
		panelMenu.add(label_13);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 258, 462, 2);
		panelMenu.add(separator_7);
		
		JLabel label = new JLabel("skdjvnksd");
		label.setBounds(318, 207, 48, 48);
		label.setIcon(new ImageIcon(ev_act));
		panelMenu.add(label);
		
		JLabel label_2 = new JLabel("Actualizacion");
		label_2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Actualizaciones act = new Actualizaciones();

				act.main(null);
				act.setEntro(false);
				frame.setVisible(false);
				
			}
		});
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		label_2.setBounds(10, 20, 183, 21);
		panelMenu.add(label_2);
		
		JLabel label_4 = new JLabel("act");
		label_4.setIcon(new ImageIcon(ic));
		label_4.setBounds(318, 12, 46, 43);
		panelMenu.add(label_4);
		
		JLabel menu = new JLabel("=");
		menu.setForeground(new Color(255, 153, 0));
		menu.setBackground(new Color(255, 153, 0));
		menu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {


				if (menu.getText().equals("=")) {

					for (int a = -314; a <= 0; a++) {
						panelMenu.setBounds(a, 74, 374, 611);

						menu.setText("<");

					}

				} else if (menu.getText().equals("<")) {

					for (int a = 0; a >= -314; a--) {
						panelMenu.setBounds(a, 74, 374, 611);
						menu.setText("=");
					}

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
		
		JLabel lblEventosParaEl = new JLabel("Eventos para el Dia de hoy!!");
		lblEventosParaEl.setForeground(new Color(255, 153, 0));
		lblEventosParaEl.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblEventosParaEl.setBounds(319, 134, 422, 43);
		panelPortero.add(lblEventosParaEl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 241, 629, 141);
		panelPortero.add(scrollPane);
	
		table = new JTable();
		table.setGridColor(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.setForeground(new Color(255, 200, 0));
		table.setBackground(Color.BLACK);
		
		JLabel label_1 = new JLabel("Desarrollado por Sergio Joel Ferreras & Sarah Ramos - Matriculas: 2016-3837 - 2016-3605");
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		label_1.setBounds(246, 642, 568, 43);
		panelPortero.add(label_1);
		
		try {
			eventosHoy();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eventosHoy() throws ClassNotFoundException {
	
		boolean existe = false;
		try {
			 
			Conexion con = new Conexion();
			Statement st = con.conectar().createStatement();
			 
			Calendar now = Calendar.getInstance();

			int dia = now.get(Calendar.DAY_OF_WEEK)-2;
			int mes = now.get(Calendar.MONTH)+1;
			int yr = now.get(Calendar.YEAR);
			
			String f_ev = " "+dia + "/" + mes + "/" + yr;
			
			String sql = "SELECT * FROM eventos where fecha = '"+f_ev+"'";
			
			ResultSet rs = st.executeQuery(sql);
		
			String presentacion[] = { "Id", "Nombre", "Tipo de evento", "Descripcion", "Fecha"};
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);
			
			while(rs.next()) {
				
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};

				forma.addRow(datos);
	
				table.setModel(forma);
				
				existe = true;
			}
			
			if(existe != true) {
				
				JLabel noExisten = new JLabel("No existen Eventos programados para hoy!! ");
				noExisten.setForeground(new Color(255, 153, 0));
				noExisten.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
				noExisten.setBounds(206, 413, 647, 43);
				panelPortero.add(noExisten);
				
				JLabel noExiste1 = new JLabel("Por favor pasa por la seccion de Proximos eventos y selecciona una fecha!");
				noExiste1.setForeground(new Color(255, 153, 0));
				noExiste1.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 20));
				noExiste1.setBounds(215, 467, 629, 43);
				panelPortero.add(noExiste1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
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
}
