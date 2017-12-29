package Clases;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class Iniciar_Sesion {

	public Boolean i = false;

	public void comoAdmin(String us, String c) {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT usuario, contra FROM usuarios where usuario = ? AND contra = ? AND tipo_perfil = 'Admin' ";

			PreparedStatement ps;
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, us);
			ps.setString(2, c);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				i = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void comoPortero(String us, String c) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssfr", "root", "");

			String sql = "SELECT usuario, contra FROM usuarios where usuario = ? AND contra = ? AND tipo_perfil = 'Portero' ";

			PreparedStatement ps;
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, us);
			ps.setString(2, c);
			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				i = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
