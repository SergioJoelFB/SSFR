package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
 
	Connection  con = null;
	Statement sentencia = null;
	public Conexion(){
		
		
	}
	 
		public Connection conectar(){
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/ssfr";
			String usuario = "root";
			String contrasena = "";
			 
			//esto nos ayuda a acceder al url usuario de la base de datos
			con = DriverManager.getConnection(url, usuario, contrasena);
			 sentencia = con.createStatement();
		}  
		catch (Exception e) {
			System.out.println("Error,  con la Base de Datos"+e);  
			//e.printStackTrace();
		}
		return con;
	}
		 
		public Connection getcon(){
			return con;
		}

	public void ejecutar(String l){
		try{
			sentencia.executeUpdate(l);
			System.out.println("Correcto");
		}catch(Exception e){
			System.out.println("Error");
		}
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	
}