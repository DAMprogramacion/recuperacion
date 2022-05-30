package jdbcInicial.modelo.conexion;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionPool {
	
	private static BasicDataSource ds = null;
    public static synchronized Connection getConnection() {
        
		Connection conn = null;
        try {
            if (ds == null) {
                Properties props = new Properties();
                URL url = ClassLoader.getSystemResource("bd.properties");
                props.load(url.openStream());
                ds = new BasicDataSource();
                ds.setDriverClassName(props.getProperty("jdbc.driver"));
                ds.setUrl(props.getProperty("jdbc.url"));
                ds.setUsername(props.getProperty("jdbc.username"));
                ds.setPassword(props.getProperty("jdbc.password"));
                ds.setInitialSize(10); // The initial number of connections that
                                        // are created when the pool is started.
                ds.setMaxTotal(20); // The maximum number of active connections
                                        // that can be allocated from this pool
            }
            conn = ds.getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void cerrarConexion(Connection conexion) {
    	if (conexion != null)
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public static void main(String[] args) {
    	Connection[] con  = new Connection[25];
    	for (int i = 0; i < 20; i++) {
    		con[i] = new ConexionPool().getConnection();
    		System.out.println(i + "--" + con[i]);
		}
    
    	cerrarConexion(con[0]);
    	con[20] = new ConexionPool().getConnection();
    	System.out.println("--------------");
    	for (int i = 0; i < 25; i++) {
    		System.out.println(i + "--" + con[i]);
		}
	}
}
