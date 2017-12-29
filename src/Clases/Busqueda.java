package Clases;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class Busqueda {
	
	public void porNombre(String nombre, DefaultTableModel forma) {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre, apellido FROM usuarios where nombre = ?";

			PreparedStatement ps;
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, nombre);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}

	public void porApellido(String apellido ) {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT nombre, apellido FROM  where nombre = ?";

			PreparedStatement ps;
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, apellido);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				

			}

		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}
	

}
