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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Clases.Conexion;

public class InvitadosPorllegar {

	private JFrame frame;

	public static Boolean entro = false;

	private String nombreDelEvento;

	JPanel panel;

	private JTable tabla_eventos;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvitadosPorllegar window = new InvitadosPorllegar();
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
	public InvitadosPorllegar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);

		new ImageIcon(this.getClass().getResource("/repo.png")).getImage();
		new ImageIcon(this.getClass().getResource("/bv.png")).getImage();
		new ImageIcon(this.getClass().getResource("/show.png")).getImage();
		new ImageIcon(this.getClass().getResource("/x_ev.png")).getImage();
		new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		new ImageIcon(this.getClass().getResource("/evn.png")).getImage();
		Image ic10 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		Image ic18 = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 650, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 650, 75);
		panel.add(panel_1);

		JLabel lblProximosEventos = new JLabel("Invitados Por Llegar");
		lblProximosEventos.setForeground(new Color(255, 153, 0));
		lblProximosEventos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblProximosEventos.setBounds(164, 20, 321, 43);
		panel_1.add(lblProximosEventos);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!isEntro()) {
					menuPortero.main(null);
					frame.setVisible(false);
				} else if (isEntro()) {
					frame.setVisible(false);
					menuAdmin.main(null);
					menuAdmin.setEntro(true);
				}
			}
		});
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setIcon(new ImageIcon(ic10));

		label_1.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_1.setBounds(20, 20, 48, 43);
		panel_1.add(label_1);

		JLabel lblInsertaUnaFecha = new JLabel("Selecciona el nombre del Evento");
		lblInsertaUnaFecha.setForeground(Color.WHITE);
		lblInsertaUnaFecha.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblInsertaUnaFecha.setBounds(29, 111, 334, 48);
		panel.add(lblInsertaUnaFecha);

		JButton buscar = new JButton("");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				buscarFaltantes();
				leerusuarios(tabla_eventos);
			}
		});
		buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buscar.setBorder(null);
		buscar.setBackground(Color.BLACK);
		buscar.setIcon(new ImageIcon(ic18));
		buscar.setBounds(256, 315, 140, 56);
		panel.add(buscar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(418, 109, 172, 61);
		panel.add(scrollPane_1);

		tabla_eventos = new JTable();
		try {
			eventos();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		scrollPane_1.setViewportView(tabla_eventos);

	}

	public void eventos() throws ClassNotFoundException {

		try {

			Conexion con = new Conexion();
			Statement st = con.conectar().createStatement();

			String sql = "SELECT nombre FROM eventos";

			ResultSet rs = st.executeQuery(sql);

			String presentacion[] = { "Nombre" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)) };

				forma.addRow(datos);

				tabla_eventos.setModel(forma);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isEntro() {
		return entro;
	}

	@SuppressWarnings("static-access")
	public void setEntro(boolean entro) {
		this.entro = entro;
	}

	public void buscarFaltantes() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre as Evento_Seleccionado, COUNT(id_invitado) AS Cantidad_que_Deben_Asistir, asistio As Cantidad_Que_Asistieron FROM eventos ev INNER JOIN invitaciones inv ON ev.id = inv.id_evento WHERE nombre = '"+ getNombreDelEvento()+ "'GROUP BY nombre HAVING COUNT(inv.id_invitado) ";
			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(66, 201, 517, 97);
			panel.add(scrollPane);

			tabla = new JTable();
			scrollPane.setViewportView(tabla);
			

			while (rs.next()) {
				String presentacion[] = { "Nombre", "Cantidad que Debe Asistir", "Cantidad que Asistieron" };

				DefaultTableModel forma = new DefaultTableModel(null, presentacion);
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tabla.setModel(forma);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void leerusuarios(JTable tabla) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (tabla.getSelectedRow() != -1) {
					int fila = tabla.getSelectedRow();
					setNombreDelEvento(tabla.getValueAt(fila, 0).toString());
				}

			}

		});

	}

	public String getNombreDelEvento() {
		return nombreDelEvento;
	}

	public void setNombreDelEvento(String nombreDelEvento) {
		this.nombreDelEvento = nombreDelEvento;
	}
}
