package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarVisitantes {

	private JFrame frame;
	private JTextField nom;
	private JTextField ap;
	private JTable tabla;
	
	public static Boolean entro = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVisitantes window = new BuscarVisitantes();
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
	public BuscarVisitantes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 500);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 550, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 550, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);

		new ImageIcon(this.getClass().getResource("/ev.png")).getImage();
		new ImageIcon(this.getClass().getResource("/borrar.png")).getImage();
		new ImageIcon(this.getClass().getResource("/editar.png")).getImage();
		Image ic15 = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		new ImageIcon(this.getClass().getResource("/invi.png")).getImage();
		Image ic8 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/act.png")).getImage();
		new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		new ImageIcon(this.getClass().getResource("/p.png")).getImage();
		new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		new ImageIcon(this.getClass().getResource("/save.png")).getImage();

		JLabel lblBusquedaDe = new JLabel("Buscar Visitantes");
		lblBusquedaDe.setBounds(146, 20, 257, 43);
		panel_1.add(lblBusquedaDe);
		lblBusquedaDe.setForeground(new Color(255, 153, 0));
		lblBusquedaDe.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		
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
		label_1.setIcon(new ImageIcon(ic8));
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_1.setBounds(20, 20, 48, 43);
		panel_1.add(label_1);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNombre.setBounds(43, 98, 130, 48);
		panel.add(lblNombre);

		nom = new JTextField();
		nom.setForeground(new Color(255, 153, 0));
		nom.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		nom.setColumns(10);
		nom.setBorder(null);
		nom.setBackground(Color.BLACK);
		nom.setBounds(287, 114, 227, 20);
		panel.add(nom);

		JSeparator separator = new JSeparator();
		separator.setBounds(287, 137, 227, 1);
		panel.add(separator);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setEnabled(false);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblApellido.setBounds(43, 157, 130, 48);
		panel.add(lblApellido);

		ap = new JTextField();
		ap.setEnabled(false);
		ap.setForeground(new Color(255, 153, 0));
		ap.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		ap.setColumns(10);
		ap.setBorder(null);
		ap.setBackground(Color.BLACK);
		ap.setBounds(287, 181, 227, 20);
		panel.add(ap);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(287, 204, 227, 1);
		panel.add(separator_1);

		tabla = new JTable();
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tabla.setForeground(Color.ORANGE);
		tabla.setBackground(Color.GRAY);
		tabla.setBounds(43, 255, 471, 59);
		panel.add(tabla);

		JCheckBox seleccion = new JCheckBox("Selecciona para buscar por apellido");
		seleccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (seleccion.isSelected()) {
					nom.setEnabled(false);
					lblNombre.setEnabled(false);
					lblApellido.setEnabled(true);
					ap.setEnabled(true);
				}else if(!seleccion.isSelected()){
					nom.setEnabled(true);
					lblNombre.setEnabled(true);
					lblApellido.setEnabled(false);
					ap.setEnabled(false);
				}
			}
		});
		seleccion.setBackground(Color.BLACK);
		seleccion.setForeground(Color.ORANGE);
		seleccion.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		seleccion.setBounds(76, 348, 359, 23);
		panel.add(seleccion);
		
		JButton buscar = new JButton("");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!seleccion.isSelected()) {
					porNombre(nom.getText());
					ap.setText("");
				}else if(seleccion.isSelected()){
					porApellido(ap.getText());
					nom.setText("");
				}

			}
		});
		buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buscar.setBorder(null);
		buscar.setIcon(new ImageIcon(ic15));
		buscar.setBackground(Color.BLACK);
		buscar.setBounds(205, 408, 140, 48);
		panel.add(buscar);
		
		JLabel label = new JLabel("Nombre");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.BOLD, 17));
		label.setBounds(43, 232, 130, 20);
		panel.add(label);
		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setForeground(Color.WHITE);
		lblApellido_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblApellido_1.setBounds(205, 232, 130, 20);
		panel.add(lblApellido_1);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEvento.setBounds(384, 232, 130, 20);
		panel.add(lblEvento);

	}

	public void porNombre(String nombre) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre, apellido, nombre_evento as Evento_al_que_asistira FROM invitados inv INNER JOIN invitaciones ev ON inv.id = ev.id_invitado WHERE nombre = ?";
			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, nombre);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {
				String presentacion[] = { "Nombre", "Apellido", "Evento al que asistira" };
				DefaultTableModel forma = new DefaultTableModel(null, presentacion);
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tabla.setModel(forma);
			}else {
				
				JOptionPane.showMessageDialog(null, "Este nombre no exite como invitado");
				nom.setText("");
			}
			

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void porApellido(String apellido) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre, apellido, nombre_evento as Evento_al_que_asistira FROM invitados inv INNER JOIN invitaciones ev ON inv.id = ev.id_invitado WHERE apellido = ?";
			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, apellido);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {
				String presentacion[] = { "Nombre", "Apellido", "Evento al que asistira" };
				DefaultTableModel forma = new DefaultTableModel(null, presentacion);
				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tabla.setModel(forma);

			}else {
				JOptionPane.showMessageDialog(null, "Este apellido no exite como invitado");
				ap.setText("");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public boolean isEntro() {
		return entro;
	}

	@SuppressWarnings("static-access")
	public  void setEntro(boolean entro) {
		this.entro = entro;
	}
}
