package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;

import Clases.Conexion;

public class Reportes {

	private JFrame frame;
	private JPanel panel;
	private JTable tablaReg1;
	private JTable tablaReg2;
	private JLabel reg3;

	private Conexion c = new Conexion();

	public static Boolean entro = false;
	private JTable tableReg4;
	private JTable tableReg5;
	private JTable tableReg6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes window = new Reportes();
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
	public Reportes() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 850, 693);
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
		new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 850, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 850, 75);
		panel.add(panel_1);

		JLabel lblProximosEventos = new JLabel("Reportes");
		lblProximosEventos.setForeground(new Color(255, 153, 0));
		lblProximosEventos.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		lblProximosEventos.setBounds(359, 20, 131, 43);
		panel_1.add(lblProximosEventos);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				menuAdmin.main(null);
				menuAdmin.setEntro(true);
			}
		});
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setIcon(new ImageIcon(ic10));

		label_1.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 36));
		label_1.setBounds(20, 20, 48, 43);
		panel_1.add(label_1);

		JLabel lblInsertaUnaFecha = new JLabel("Cantidad de personas que fueron a cada evento");
		lblInsertaUnaFecha.setForeground(Color.WHITE);
		lblInsertaUnaFecha.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblInsertaUnaFecha.setBounds(29, 111, 388, 48);
		panel.add(lblInsertaUnaFecha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(499, 94, 341, 96);
		panel.add(scrollPane);

		tablaReg1 = new JTable();
		scrollPane.setViewportView(tablaReg1);

		JLabel lblDeLas = new JLabel("% de las personas en la lista que asistieron a cada evento");
		lblDeLas.setForeground(Color.WHITE);
		lblDeLas.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDeLas.setBounds(29, 234, 453, 48);
		panel.add(lblDeLas);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(502, 213, 338, 95);
		panel.add(scrollPane_1);

		tablaReg2 = new JTable();
		scrollPane_1.setViewportView(tablaReg2);

		JLabel lblEventosMs = new JLabel("Eventos m\u00E1s visitados");
		lblEventosMs.setForeground(Color.WHITE);
		lblEventosMs.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEventosMs.setBounds(29, 341, 453, 48);
		panel.add(lblEventosMs);

		reg3 = new JLabel("");
		reg3.setForeground(Color.WHITE);
		reg3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		reg3.setBounds(499, 341, 140, 48);
		panel.add(reg3);

		JLabel lblEventosMsVisitados = new JLabel("Eventos m\u00E1s visitados por mujeres");
		lblEventosMsVisitados.setForeground(Color.WHITE);
		lblEventosMsVisitados.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEventosMsVisitados.setBounds(29, 424, 453, 48);
		panel.add(lblEventosMsVisitados);

		JLabel lblEventosMsVisitados_1 = new JLabel("Eventos m\u00E1s visitados por hombre");
		lblEventosMsVisitados_1.setForeground(Color.WHITE);
		lblEventosMsVisitados_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEventosMsVisitados_1.setBounds(29, 516, 453, 48);
		panel.add(lblEventosMsVisitados_1);

		JLabel lblDasDeLa = new JLabel("D\u00EDas de la semana en que asisten m\u00E1s personas a eventos");
		lblDasDeLa.setForeground(Color.WHITE);
		lblDasDeLa.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDasDeLa.setBounds(29, 605, 453, 48);
		panel.add(lblDasDeLa);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(499, 424, 290, 58);
		panel.add(scrollPane_2);

		tableReg4 = new JTable();
		scrollPane_2.setViewportView(tableReg4);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(499, 506, 290, 58);
		panel.add(scrollPane_3);

		tableReg5 = new JTable();
		scrollPane_3.setViewportView(tableReg5);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(499, 605, 287, 48);
		panel.add(scrollPane_4);

		tableReg6 = new JTable();
		scrollPane_4.setViewportView(tableReg6);

		reporteCantPersonas();
		eventoMasVis();
		eventoMasVisMuj();
		eventoMasVisHom();
		eventoMasVisSema();

	}

	public boolean isEntro() {
		return entro;
	}

	@SuppressWarnings("static-access")
	public void setEntro(boolean entro) {
		this.entro = entro;
	}

	public void reporteCantPersonas() {

		String presentacion[] = { "Nombre del Evento", "Visitas", "Tipo de Evento" };
		DefaultTableModel forma = new DefaultTableModel(null, presentacion);
		try {

			Statement st = c.conectar().createStatement();

			String sql = "SELECT nombre as evento_mas_visitado, COUNT(id) as visitas, tipo_evento AS tipo_evento FROM eventos i INNER JOIN invitaciones iv On i.id = iv.id_evento GROUP BY id HAVING COUNT(iv.id_evento)";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tablaReg1.setModel(forma);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reportePorcListaEvento() {

		String presentacion[] = { "Nombre del Evento", "Visitas", "Tipo de Evento" };
		DefaultTableModel forma = new DefaultTableModel(null, presentacion);
		try {

			Statement st = c.conectar().createStatement();

			String sql = "SELECT nombre as evento_mas_visitado, COUNT(id) as visitas, tipo_evento AS tipo_evento FROM eventos i INNER JOIN invitaciones iv On i.id = iv.id_evento GROUP BY id HAVING COUNT(iv.id_evento)";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tablaReg2.setModel(forma);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eventoMasVis() {

		String presentacion[] = { "Nombre del Evento", "Visitas", "Tipo de Evento" };
		new DefaultTableModel(null, presentacion);

		try {
			Statement st = c.conectar().createStatement();

			String sql = "SELECT nombre as evento_mas_visitado, COUNT(id) as visitas, tipo_evento AS tipo_evento FROM eventos i INNER JOIN invitaciones iv On i.id = iv.id_evento GROUP BY id HAVING COUNT(iv.id_evento) / 100 * COUNT(iv.id_invitado) ";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String r = rs.getString(1);

				reg3.setText(r);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void eventoMasVisMuj() {

		String presentacion[] = { "Nombre del Evento", "Sexo", "Cantidad" };
		DefaultTableModel forma = new DefaultTableModel(null, presentacion);

		try {
			Statement st = c.conectar().createStatement();

			String sql = "SELECT ev.nombre, sexo, COUNT(sexo) as Cantidad FROM eventos ev INNER JOIN invitaciones inv ON ev.id = inv.id_evento INNER JOIN invitados ina ON inv.id_invitado = ina.id WHERE sexo LIKE 'F' GROUP BY nombre";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tableReg4.setModel(forma);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void eventoMasVisHom() {

		String presentacion[] = { "Nombre del Evento", "Sexo", "Cantidad" };
		DefaultTableModel forma = new DefaultTableModel(null, presentacion);

		try {
			Statement st = c.conectar().createStatement();

			String sql = "SELECT ev.nombre, sexo, COUNT(sexo) as Cantidad FROM eventos ev INNER JOIN invitaciones inv ON ev.id = inv.id_evento INNER JOIN invitados ina ON inv.id_invitado = ina.id WHERE sexo LIKE 'M' GROUP BY nombre";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tableReg5.setModel(forma);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void eventoMasVisSema() {

		String presentacion[] = { "Nombre del Evento", "Cantidad", "Fecha" };
		DefaultTableModel forma = new DefaultTableModel(null, presentacion);

		try {
			Statement st = c.conectar().createStatement();

			String sql = "SELECT nombre as evento_mas_visitado, COUNT(fecha) as visitas, fecha AS fecha_mas_visitada FROM eventos i INNER JOIN invitaciones iv On i.id = iv.id_evento GROUP BY fecha HAVING COUNT(iv.id_evento) / 100 * COUNT(i.id)";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String datos[] = { String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3) };

				forma.addRow(datos);

				tableReg6.setModel(forma);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
