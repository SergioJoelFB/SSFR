package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Clases.Admin;
import Clases.Iniciar_Sesion;
import Clases.Portero;
import Clases.Registro;

import java.sql.*;

public class Registro_Login {

	private int x;
	private int y;

	/**
	 * Para hacer que solo se pueda seleccionar un solo Radio button a la vez
	 */
	ButtonGroup grupo;

	Admin admin;

	Portero port;

	Registro reg;

	private JFrame frame;
	private JTextField nombre_text;
	private JTextField apellido_text;
	private JTextField usuario_text;
	private JPasswordField contra_text;
	private JPasswordField rep_contra_text;
	private JTextField usu;
	private JPasswordField con_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Login window = new Registro_Login();
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
	public Registro_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		grupo = new ButtonGroup();

		frame = new JFrame();
		frame.setTitle("Sistema Gestor de Invitados (Sergio Ferreras & Sarah Ramos) Mats: 2016-3837 2016-3605");
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 680, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel super_panel = new JPanel();
		super_panel.setBackground(Color.BLACK);
		super_panel.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent ev) {
				x = ev.getX();
				y = ev.getY();
			}

		});
		super_panel.addMouseMotionListener(new MouseMotionAdapter() {

			private int x;
			private int y;

			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen() - this.x;
				int y = evt.getYOnScreen() - this.y;
				frame.setLocation(x, y);

			}
		});
		super_panel.setBounds(0, 0, 680, 500);
		frame.getContentPane().add(super_panel);
		super_panel.setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(384, 156, 265, 321);
		super_panel.add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.setBackground(new Color(51, 51, 51));

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(102, 11, 60, 32);
		panelLogin.add(lblLogin);
		lblLogin.setForeground(Color.ORANGE);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblLogin.setBackground(new Color(255, 255, 204));

		JCheckBox soy_admin = new JCheckBox("Admin? Seleccioname");
		soy_admin.setForeground(new Color(255, 153, 0));
		soy_admin.setFont(new Font("Century Gothic", Font.BOLD, 16));
		soy_admin.setBorder(new EmptyBorder(0, 0, 0, 0));
		soy_admin.setBackground(new Color(51, 51, 51));
		soy_admin.setBounds(34, 217, 197, 23);
		panelLogin.add(soy_admin);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings({ "static-access" })
			public void actionPerformed(ActionEvent arg0) {

				Iniciar_Sesion in = new Iniciar_Sesion();

				if (!usu.getText().trim().equals("") || con_text.getPassword() != null) {

					if (soy_admin.isSelected()) {

						String us = usu.getText();
						String c = String.valueOf(con_text.getPassword());

						in.comoAdmin(us, c);

						if (in.i.equals(true)) {

							JOptionPane.showMessageDialog(null, "Bienvenido al sistema");

							menuAdmin m = new menuAdmin();
							menuAdmin.setEntro(true);
							m.main(null);

							frame.setVisible(false);

						} else {
							JOptionPane.showMessageDialog(null, "No eres el Administrador! o intentalo de nuevo");
						}

					} else {
						String us = usu.getText();
						String c = String.valueOf(con_text.getPassword());

						in.comoPortero(us, c);

						if (in.i.equals(true)) {
							JOptionPane.showMessageDialog(null, "Bienvenido al sistema");

							menuPortero m = new menuPortero();
							m.main(null);

							frame.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,	"No eres un portero!, intentalo de nuevo o anda y registrate");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No puede dejar NADA vacio");

				}

			}
		});
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnLogin.setBounds(67, 256, 131, 54);
		btnLogin.setOpaque(true);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(new Color(255, 153, 0));
		panelLogin.add(btnLogin);

		usu = new JTextField();
		usu.setHorizontalAlignment(SwingConstants.CENTER);
		usu.setForeground(Color.ORANGE);
		usu.setBorder(null);
		usu.setBackground(new Color(51, 51, 51));
		usu.setBounds(74, 97, 117, 20);
		panelLogin.add(usu);
		usu.setColumns(10);

		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setBounds(102, 54, 60, 32);
		panelLogin.add(lblUsuario_1);
		lblUsuario_1.setForeground(Color.ORANGE);
		lblUsuario_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblUsuario_1.setBackground(new Color(255, 255, 204));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(87, 134, 90, 32);
		panelLogin.add(lblContrasea);
		lblContrasea.setForeground(Color.ORANGE);
		lblContrasea.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblContrasea.setBackground(new Color(255, 255, 204));

		con_text = new JPasswordField();
		con_text.setForeground(Color.PINK);
		con_text.setHorizontalAlignment(SwingConstants.CENTER);
		con_text.setBounds(71, 177, 123, 20);
		con_text.setBorder(null);
		con_text.setBackground(new Color(51, 51, 51));
		panelLogin.add(con_text);
		con_text.setColumns(10);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.WHITE);
		separator_5.setBounds(74, 120, 117, 2);
		panelLogin.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.WHITE);
		separator_6.setBounds(74, 197, 117, 2);
		panelLogin.add(separator_6);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBounds(32, 57, 285, 385);
		super_panel.add(panelRegistro);
		panelRegistro.setBackground(new Color(51, 51, 51));
		panelRegistro.setLayout(null);

		JLabel lblRegistrate = new JLabel("Registrate");
		lblRegistrate.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblRegistrate.setForeground(Color.ORANGE);
		lblRegistrate.setBackground(new Color(255, 255, 204));
		lblRegistrate.setBounds(84, 11, 116, 32);
		panelRegistro.add(lblRegistrate);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 265, 8);
		panelRegistro.add(separator);

		JPanel panelTipoUsuario = new JPanel();
		panelTipoUsuario.setBackground(new Color(102, 102, 102));
		panelTipoUsuario.setBounds(10, 125, 265, 161);
		panelRegistro.add(panelTipoUsuario);
		panelTipoUsuario.setLayout(null);

		JCheckBox no_reg = new JCheckBox("A\u00FAn no estoy Registrado");
		no_reg.setBorder(null);
		no_reg.setForeground(new Color(255, 153, 0));
		no_reg.setFont(new Font("Century Gothic", Font.BOLD, 16));
		no_reg.setBackground(new Color(102, 102, 102));
		no_reg.setBounds(22, 69, 218, 23);
		panelTipoUsuario.add(no_reg);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 356, 265, 8);
		panelRegistro.add(separator_1);

		JPanel panelRegistroUsuarios = new JPanel();
		panelRegistroUsuarios.setBounds(32, 41, 285, 418);
		super_panel.add(panelRegistroUsuarios);
		panelRegistroUsuarios.setBackground(new Color(102, 102, 102));
		panelRegistroUsuarios.setVisible(false);
		panelRegistroUsuarios.setLayout(null);

		JButton btnProceder = new JButton("Proceder");
		btnProceder.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnProceder.setForeground(new Color(0, 0, 0));
		btnProceder.setBackground(new Color(255, 153, 0));
		btnProceder.setOpaque(true);
		btnProceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (no_reg.isSelected()) {
					panelRegistro.setVisible(false);
					panelRegistroUsuarios.setVisible(true);
				}

			}
		});
		btnProceder.setBounds(84, 322, 116, 23);
		panelRegistro.add(btnProceder);

		JLabel r = new JLabel("");
		r.setBounds(126, 64, 32, 67);
		Image img = new ImageIcon(this.getClass().getResource("/reg.png")).getImage();
		r.setIcon(new ImageIcon(img));
		panelRegistro.add(r);

		JLabel lblIngresaLosDatos = new JLabel("Ingresa los Datos");
		lblIngresaLosDatos.setForeground(Color.ORANGE);
		lblIngresaLosDatos.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblIngresaLosDatos.setBackground(new Color(255, 255, 204));
		lblIngresaLosDatos.setBounds(52, 11, 189, 32);
		panelRegistroUsuarios.add(lblIngresaLosDatos);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 399, 265, 8);
		panelRegistroUsuarios.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 51, 265, 8);
		panelRegistroUsuarios.add(separator_4);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(10, 63, 265, 289);
		panelRegistroUsuarios.add(panel);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNombre.setBackground(new Color(255, 255, 204));
		lblNombre.setBounds(10, 25, 80, 32);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.ORANGE);
		lblApellido.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblApellido.setBackground(new Color(255, 255, 204));
		lblApellido.setBounds(10, 65, 80, 32);
		panel.add(lblApellido);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.ORANGE);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUsuario.setBackground(new Color(255, 255, 204));
		lblUsuario.setBounds(10, 108, 80, 32);
		panel.add(lblUsuario);

		JLabel lblContra = new JLabel("Contrase\u00F1a:");
		lblContra.setForeground(Color.ORANGE);
		lblContra.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblContra.setBackground(new Color(255, 255, 204));
		lblContra.setBounds(10, 151, 96, 32);
		panel.add(lblContra);

		JLabel lblPerfilDeUsuario = new JLabel("Perfil de Usuario:");
		lblPerfilDeUsuario.setForeground(Color.ORANGE);
		lblPerfilDeUsuario.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPerfilDeUsuario.setBackground(new Color(255, 255, 204));
		lblPerfilDeUsuario.setBounds(10, 249, 138, 32);
		panel.add(lblPerfilDeUsuario);

		nombre_text = new JTextField();
		nombre_text.setBorder(null);
		nombre_text.setBackground(new Color(51, 51, 51));
		nombre_text.setForeground(Color.ORANGE);
		nombre_text.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		nombre_text.setBounds(138, 33, 117, 20);
		nombre_text.setColumns(10);
		panel.add(nombre_text);

		apellido_text = new JTextField();
		apellido_text.setBorder(null);
		apellido_text.setBackground(new Color(51, 51, 51));
		apellido_text.setForeground(Color.ORANGE);
		apellido_text.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		apellido_text.setColumns(10);
		apellido_text.setBounds(138, 73, 117, 20);
		panel.add(apellido_text);

		usuario_text = new JTextField();
		usuario_text.setBorder(null);
		usuario_text.setBackground(new Color(51, 51, 51));
		usuario_text.setForeground(Color.ORANGE);
		usuario_text.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		usuario_text.setColumns(10);
		usuario_text.setBounds(138, 116, 117, 20);
		panel.add(usuario_text);

		contra_text = new JPasswordField(16);
		contra_text.setBorder(null);
		contra_text.setBackground(new Color(51, 51, 51));
		contra_text.setForeground(Color.ORANGE);
		contra_text.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contra_text.setHorizontalAlignment(SwingConstants.CENTER);
		contra_text.setColumns(10);
		contra_text.setBounds(138, 159, 117, 20);
		panel.add(contra_text);

		JLabel lblRepetirContra = new JLabel("Repetir Contrase\u00F1a");
		lblRepetirContra.setForeground(Color.ORANGE);
		lblRepetirContra.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblRepetirContra.setBackground(new Color(255, 255, 204));
		lblRepetirContra.setBounds(59, 183, 146, 32);
		panel.add(lblRepetirContra);

		rep_contra_text = new JPasswordField();
		rep_contra_text.setBorder(null);
		rep_contra_text.setBackground(new Color(51, 51, 51));
		rep_contra_text.setForeground(Color.ORANGE);
		rep_contra_text.setHorizontalAlignment(SwingConstants.CENTER);
		rep_contra_text.setColumns(10);
		rep_contra_text.setBounds(74, 226, 117, 20);
		panel.add(rep_contra_text);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 257, 97, 21);
		comboBox.addItem("Admin");
		comboBox.addItem("Portero");
		panel.add(comboBox);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.WHITE);
		separator_7.setBounds(138, 55, 117, 2);
		panel.add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBackground(Color.WHITE);
		separator_8.setBounds(138, 95, 117, 2);
		panel.add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.WHITE);
		separator_9.setBounds(138, 138, 117, 2);
		panel.add(separator_9);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(Color.WHITE);
		separator_10.setBounds(138, 181, 117, 2);
		panel.add(separator_10);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(Color.WHITE);
		separator_11.setBounds(74, 249, 117, 2);
		panel.add(separator_11);

		JButton btnRegistrar = new JButton("Registrar ");
		btnRegistrar.setOpaque(true);
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				reg = new Registro();

				if (reg.exite_admin == true) {

					JOptionPane.showMessageDialog(null, "Ya EXISTE un Administrador!!!");

				} else if (reg.exite_admin == false) {

					if (comboBox.getSelectedItem().equals("Admin")) {

						String n = nombre_text.getText();
						String a = apellido_text.getText();
						String u = usuario_text.getText();
						String c = String.valueOf(contra_text.getPassword());
						String rep = String.valueOf(rep_contra_text.getPassword());

						String tip_perfil = "Admin";

						if (!(nombre_text.getText().trim().isEmpty() || apellido_text.getText().trim().isEmpty() || usuario_text.getText().trim().isEmpty() || c == rep)) {

							admin = new Admin(n, a, u, c);

							reg = new Registro();

							try {
								reg.registrarAdmin(admin, tip_perfil);

								nombre_text.setText("");
								apellido_text.setText("");
								usuario_text.setText("");
								contra_text.setText("");
								rep_contra_text.setText("");

							} catch (SQLException e) {
								e.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null,"No puede dejar NADA vacio, o las contraseñas no coinciden");
							nombre_text.setText("");
							apellido_text.setText("");
							usuario_text.setText("");
							contra_text.setText("");
							rep_contra_text.setText("");
						}
					}

					if (comboBox.getSelectedItem().equals("Portero")) {

						String n = nombre_text.getText();
						String a = apellido_text.getText();
						String u = usuario_text.getText();
						String c = String.valueOf(contra_text.getPassword());
						String rep = String.valueOf(rep_contra_text.getPassword());

						String tip_perfil = "Portero";

						if (!(nombre_text.getText().trim().isEmpty() || apellido_text.getText().trim().isEmpty() || usuario_text.getText().trim().isEmpty() || c == rep)) {

							port = new Portero(n, a, u, c);

							reg = new Registro();

							try {

								reg.registrarPortero(port, tip_perfil);

								nombre_text.setText("");
								apellido_text.setText("");
								usuario_text.setText("");
								contra_text.setText("");
								rep_contra_text.setText("");

							} catch (SQLException e) {
								e.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null, "No puede dejar NADA vacio, o las contraseñas no coinciden");
							nombre_text.setText("");
							apellido_text.setText("");
							usuario_text.setText("");
							contra_text.setText("");
							rep_contra_text.setText("");
						}
					}
				}
			}
		});

		btnRegistrar.setBackground(new Color(255, 153, 0));
		btnRegistrar.setBounds(159, 365, 116, 23);
		panelRegistroUsuarios.add(btnRegistrar);

		JButton btnVolver = new JButton("Volver atr\u00E1s");
		btnVolver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				panelRegistro.setVisible(true);
				panelRegistroUsuarios.setVisible(false);
				nombre_text.setText("");
				apellido_text.setText("");
				usuario_text.setText("");
				contra_text.setText("");
				rep_contra_text.setText("");

			}
		});
		btnVolver.setOpaque(true);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setBackground(new Color(255, 153, 0));
		btnVolver.setBounds(10, 365, 116, 23);
		panelRegistroUsuarios.add(btnVolver);

		JSeparator separator_2 = new JSeparator(JSeparator.VERTICAL);
		separator_2.setBounds(349, 0, 11, 500);
		super_panel.add(separator_2);
		separator_2.setBackground(new Color(255, 204, 0));

		JLabel salir = new JLabel("X");
		salir.setForeground(new Color(255, 153, 0));
		salir.setFont(new Font("Century Gothic", Font.BOLD, 18));
		salir.setBackground(new Color(51, 0, 51));
		salir.setBounds(658, 0, 12, 31);
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
		super_panel.add(salir);

		JLabel label = new JLabel("");
		label.setBounds(468, 46, 96, 99);
		super_panel.add(label);
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img1));

	}
}
