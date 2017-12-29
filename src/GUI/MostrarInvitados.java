package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MostrarInvitados {

	private JFrame frame;
	JPanel panel;
	private JTable tabla_invitados;

	public static Boolean entro = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarInvitados window = new MostrarInvitados();
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
	public MostrarInvitados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 750, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		new ImageIcon(this.getClass().getResource("/borrar.png")).getImage();
		new ImageIcon(this.getClass().getResource("/editar.png")).getImage();
		new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		new ImageIcon(this.getClass().getResource("/invi.png")).getImage();
		new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		Image ic10 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		new ImageIcon(this.getClass().getResource("/save.png")).getImage();

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 750, 74);
		panel.add(panel_1);

		JLabel lblMostrarInvitados = new JLabel("Mostrar Invitados");
		lblMostrarInvitados.setForeground(new Color(255, 153, 0));
		lblMostrarInvitados.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblMostrarInvitados.setBounds(243, 20, 264, 43);
		panel_1.add(lblMostrarInvitados);

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

		llenarTablaInvitados();

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
			scrollPane.setBorder(null);
			scrollPane.setForeground(Color.ORANGE);
			scrollPane.setBackground(Color.BLACK);
			scrollPane.setBounds(10, 85, 730, 604);
			panel.add(scrollPane);

			tabla_invitados = new JTable();
			tabla_invitados.setBorder(null);
			tabla_invitados.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
			tabla_invitados.setForeground(Color.ORANGE);
			tabla_invitados.setBackground(Color.BLACK);
			tabla_invitados.setBounds(10, 102, 530, 332);
			scrollPane.setViewportView(tabla_invitados);

			String presentacion[] = { "id", "nombre", "apellido", "telefono", "direccion", "email" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };

				forma.addRow(datos);

				tabla_invitados.setModel(forma);
			}

		} catch (Exception e) {
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
}
