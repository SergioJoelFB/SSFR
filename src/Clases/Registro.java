package Clases;

import Clases.Conexion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import  java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Registro {

	public boolean exite_admin = false;
	
	public boolean existeInvitado = false;
	
	public boolean existeEvento = false;

	public boolean verificar(String es_admin) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT * FROM usuarios where tipo_perfil = ? ";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, es_admin);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				return exite_admin = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	
	public boolean verificarIdInvitado(int id) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT * FROM invitados where id = ? ";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				return existeInvitado = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean verificarIdEvento(int id) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT * FROM eventos where id = ? ";

			PreparedStatement ps;

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				return existeEvento = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public void registrarAdmin(Usuario us, String tip_perfil) throws SQLException {

		if (verificar(tip_perfil) == true) {

			JOptionPane.showMessageDialog(null, "Ya EXISTE un Administrador!!!");

		} else if (verificar(tip_perfil) == false) {

			String n = us.getNombre();
			String a = us.getApellido();
			String u = us.getUsuario();
			String c = String.valueOf(us.getContra());

			try {
				Conexion con = new Conexion();

				Statement statement = con.conectar().createStatement();

				String sql = "insert into usuarios(nombre, apellido, usuario, contra, tipo_perfil) values ('" + n
						+ "', '" + a + "', '" + u + "', '" + c + "', '" + tip_perfil + "')";

				statement.executeUpdate(sql);

				JOptionPane.showMessageDialog(null, "Usuario Administrador registrado con exito");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	public void registrarPortero(Usuario us, String tip_perfil) throws SQLException {
		
		String n = us.getNombre();
		String a = us.getApellido();
		String u = us.getUsuario();
		String c = String.valueOf(us.getContra());

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");
			Statement statement = con.createStatement();

			((java.sql.Statement) statement).executeUpdate("insert into usuarios(nombre, apellido, usuario, contra, tipo_perfil) values ('" + n + "', '" + a + "', '" + u + "', '" + c + "','" + tip_perfil + "')");

			JOptionPane.showMessageDialog(null, "Usuario Portero registrado con exito");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void registrarEvento(Eventos e, String tip) {

		int id = e.getId();
		
		if(verificarIdEvento(id) == true) {
			JOptionPane.showMessageDialog(null, "Este ID ya existe!!");
		}else {
			if(verificarIdEvento(id) == false) {
				String n = e.getNombre();
				String f = e.getFecha();
				String u = e.getUbic();
				String t = tip;

				try {
				
					Conexion con = new Conexion();
					Connection cn = con.conectar();
					
					cn.createStatement();
					
					 String sql= "insert into eventos(id, nombre, ubicacion, tipo_evento, fecha) values ('"+ id +"', '" + n + "', '"+ u + "', '" + t + "', '" + f + "')";
					   
					con.ejecutar(sql);
				    
					JOptionPane.showMessageDialog(null,	"Evento registrado con exito, Si quieres realizar una invitacion selecciona el boton de 'Desea hacer una invitacion' ");


				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
		}
	}

	public void registrarInvitado(Invitado inv, String sex, String nom_ev, String tip_ev) {

		int id = inv.getId();
		
		if(verificarIdInvitado(id) == true) {
			
			JOptionPane.showMessageDialog(null, "Este ID ya existe!!");
		
		}else {
			if(verificarIdInvitado(id) == false) {
			
				String nombre = inv.getNombre();
				String apellido = inv.getApellido();
				String telefono = inv.getTelefono();
				String direccion = inv.getDireccion();
				String email = inv.getEmail();

				try {

					Class.forName("com.mysql.jdbc.Driver");

					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");
					Statement statement = con.createStatement();

					((java.sql.Statement) statement).executeUpdate("insert into invitados(id, nombre, apellido, telefono, direccion, sexo, email, nombre_evento, tipo_evento) values ('"+ id +"', '"+ nombre + "', '" + apellido + "', '" + telefono + "', '" + direccion + "', '" + sex + "', '" + email + "', '" + nom_ev + "', '" + tip_ev + "' )");

					JOptionPane.showMessageDialog(null, "Invitado registrado con exito");

					con.close();

				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
		}
	}
	
	public void registrarInvitacion(int id_Invitado, int id_Evento) {

		int id_invitado = id_Invitado;
		int id_evento = id_Evento;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");
			Statement statement = con.createStatement();

			((java.sql.Statement) statement).executeUpdate("insert into invitaciones(id_invitado, id_evento) values ('"+ id_invitado + "', '" + id_evento + "')");

			JOptionPane.showMessageDialog(null, "Invitacion registrada con exito");

			con.close();

		} catch (Exception e5) {
			e5.printStackTrace();
		}

	}

}
