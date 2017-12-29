
package Clases;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Mantenimiento {
	Conexion c = new Conexion();
	private String id1;

	public void guardarusuarios(Usuario us) {

		try {
			String nom = us.getNombre();
			String ap = us.getApellido();
			String usuario = us.getUsuario();
			String cont = us.getContra();
			String tip_perfil = "Portero";

			Statement miStatement = c.conectar().createStatement();
			String sql = "INSERT INTO usuarios ( nombre, apellido, usuario, contra, tipo_perfil) VALUES ('" + nom
					+ "','" + ap + "','" + usuario + "','" + cont + "','" + tip_perfil + "')";
			miStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se Han Guardados los datos correctamente");

		} catch (Exception i) {
			JOptionPane.showMessageDialog(null, "Existe un problema al  guardar");
		}
	}

	public void guardarinvitaciones(Usuario us) {

		try {
			String nom = us.getNombre();
			String ap = us.getApellido();
			String usuario = us.getUsuario();
			String cont = us.getContra();
			String tip_perfil = "Portero";

			Statement miStatement = c.conectar().createStatement();
			String sql = "INSERT INTO usuarios ( nombre, apellido, usuario, contra, tipo_perfil) VALUES ('" + nom
					+ "','" + ap + "','" + usuario + "','" + cont + "','" + tip_perfil + "')";
			miStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se Han Guardados los datos correctamente");

		} catch (Exception i) {
			JOptionPane.showMessageDialog(null, "Existe un problema al  guardar");
		}
	}

	public void guardarinvitado(Invitado invitado) {
		try {

			String nom = invitado.getNombre();
			String ap = invitado.getApellido();
			String tele = invitado.getTelefono();
			String direccion = invitado.getDireccion();
			String sexo = invitado.getSexo();
			String email = invitado.getEmail();

			Statement miStatement = c.conectar().createStatement();
			String sql = "INSERT INTO  invitados (nombre,apellido,telefono,direccion,sexo,email ) VALUES ('" + nom
					+ "','" + ap + "','" + tele + "','" + direccion + "','" + sexo + "','" + email + "')";
			miStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se Han Guardados los datos correctamente");
			
		} catch (Exception i) {
			JOptionPane.showMessageDialog(null, "Existe un problema al  guardar");
		}

	}

	public void guardareventos(Eventos eventos) {
		try {
			String nom = eventos.getNombre();
			String fecha = eventos.getFecha();
			String ubicacion = eventos.getUbic();
			String tipo_evento = eventos.getTipo_evento();

			Conexion con = new Conexion();
			Connection cn = con.conectar();

			cn.createStatement();

			String sql = "INSERT INTO eventos (nombre,fecha,ubicacion,tipo) VALUES ('" + nom + "','" + fecha + "','"
					+ ubicacion + "','" + tipo_evento + "')";

			con.ejecutar(sql);

			JOptionPane.showMessageDialog(null, "Se Han Guardados los datos correctamente");

		} catch (Exception i) {
			JOptionPane.showMessageDialog(null, "Existe un problema al  guardar");
		}
	}

	public void eliminarusuario(String id) {
		try {

			Statement miStatement = c.conectar().createStatement();
			String sql = "DELETE FROM usuarios WHERE id like '" + id + "'";
			miStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha Eliminado Correctamente");
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "No se ha Eliminado");

		}
	}

	public void modificarusuarios(Usuario us, String tip_perfil, String id) {

		try {
			Statement miStatement = c.conectar().createStatement();
			String sql = "update ignore usuarios set nombre ='" + us.getNombre() + "', apellido = '" + us.getApellido()
					+ "', usuario = '" + us.getUsuario() + "', contra = '" + us.getContra() + "', tip_perfil = '"
					+ tip_perfil + "' WHERE id like '" + id1 + "' ";
			miStatement.execute(sql);

			JOptionPane.showMessageDialog(null, "Se modifico");
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "No se modifico");

		}

	}

	public void modificarinvitados(String nombre, String apellido, String telefono, String direccion, String email,
			String id) {
		try {

			Connection cn = c.conectar();

			String sql = "UPDATE invitados set nombre = ?, apellido = ?, telefono = ?, direccion = ?, email = ? where id = ?";

			PreparedStatement ps;
			ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, direccion);
			ps.setString(5, email);
			ps.setString(6, id);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se modifico");

		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "No se modifico");
		}
	}

	public void modificareventos(String nombre, String fecha, String ubicacion, String tipo) {
		try {
			Statement miStatement = c.conectar().createStatement();
			String sql = "update eventos set nombre='" + nombre + "', fecha='" + fecha + "',ubicacion='" + ubicacion
					+ "',tipo='" + tipo + "' WHERE nombre ='" + id1 + "'";
			miStatement.execute(sql);

			JOptionPane.showMessageDialog(null, "Se modifico");
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "No se modifico");

		}
	}

}
