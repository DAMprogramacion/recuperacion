package jdbcInicial.modelo.conexion;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private Connection conexion;
	public Conexion() throws SQLException, IOException {
		
		 Properties properties = new Properties();
	     URL url = ClassLoader.getSystemResource("bd.properties");
	     properties.load(url.openStream());
	     String sURL = properties.getProperty("jdbc.url");
	     
	     String user = properties.getProperty("jdbc.username");
	     String pass = properties.getProperty("jdbc.password");
	   
	 	 conexion = DriverManager.getConnection(sURL + "?user=" + user 
	 			 + "&password=" + pass);
	 	//System.out.println(conexion); 
	}
	
	public Connection getConexion() {
		return conexion;
	}
	public void cerrarConexion() throws SQLException {
		if (conexion != null)
			conexion.close();
	}
	public static void main(String[] args) throws SQLException, IOException {
		new Conexion();
	}

	
}
