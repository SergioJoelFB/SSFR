package GUI;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Clases.Conexion;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProximosEventos {

	private JFrame frame;
	private JTable tabla;
	private JDateChooser prox;
	
	public static Boolean entro = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProximosEventos window = new ProximosEventos();
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
	public ProximosEventos() {
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
		Image ic10 = new ImageIcon(this.getClass().getResource("/gb.png")).getImage();
		Image ic18 = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 650, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 650, 75);
		panel.add(panel_1);

		JLabel lblProximosEventos = new JLabel("Proximos Eventos");
		lblProximosEventos.setForeground(new Color(255, 153, 0));
		lblProximosEventos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblProximosEventos.setBounds(193, 20, 264, 43);
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 630, 102);
		panel.add(scrollPane);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		JLabel lblInsertaUnaFecha = new JLabel("Inserta una fecha limite");
		lblInsertaUnaFecha.setForeground(Color.WHITE);
		lblInsertaUnaFecha.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblInsertaUnaFecha.setBounds(29, 111, 248, 48);
		panel.add(lblInsertaUnaFecha);

		JButton buscar = new JButton("");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eventosProximos();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buscar.setBorder(null);
		buscar.setBackground(Color.BLACK);
		buscar.setIcon(new ImageIcon(ic18));
		buscar.setBounds(255, 333, 140, 56);
		panel.add(buscar);

	    prox = new JDateChooser();
		prox.setBounds(428, 127, 155, 20);
		panel.add(prox);

	}

	public void eventosProximos() throws ClassNotFoundException {

		try {

			Conexion con = new Conexion();
			Statement st = con.conectar().createStatement();

			Calendar now = Calendar.getInstance();

			int dia = now.get(Calendar.DAY_OF_WEEK)-2;
			int mes = now.get(Calendar.MONTH)+1;
			int yr = now.get(Calendar.YEAR);

			int dia_prox = prox.getCalendar().get(Calendar.DAY_OF_WEEK)-2;
			int mes_prox = prox.getCalendar().get(Calendar.MONTH)+1;
			int yr_prox = prox.getCalendar().get(Calendar.YEAR);

			String f_prox = " "+ dia_prox + "/" + mes_prox + "/" + yr_prox;

			String f_ev = " "+ dia + "/" + mes + "/" + yr;

			String sql = "SELECT * FROM eventos WHERE fecha BETWEEN '" + f_ev + "' AND '" + f_prox + "'";

			ResultSet rs = st.executeQuery(sql);

			String presentacion[] = { "Id", "Nombre", "Tipo de evento", "Descripcion", "Fecha" };
			DefaultTableModel forma = new DefaultTableModel(null, presentacion);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

				forma.addRow(datos);

				tabla.setModel(forma);
				
			}
			
			if(rs.next() == false) {
				JOptionPane.showMessageDialog(null, "No existen eventos entre el dia de hoy y el dia que elegiste, por favor elige otro dia u otro mes");
			}
			
		} catch (SQLException e) {
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
