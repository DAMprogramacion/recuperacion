import java.io.IOException;
import java.sql.SQLException;

import jdbcInicial.modelo.conexion.Conexion;
import jdbcInicial.modelo.dao.Marca;
import jdbcInicial.modelo.dao.Ordenador;
import jdbcInicial.modelo.dao.OrdenadorDAO;
import jdbcInicial.modelo.dao.OrdenadorDAOImpl;
import jdbcInicial.modelo.dao.TipoDisco;

public class Test {
	public static void main(String[] args) {
		probarConexion();
		OrdenadorDAO dao = new OrdenadorDAOImpl();
		Ordenador ordenador = new Ordenador(4, 3.3f, 1000,
				TipoDisco.MAGNETICO, Marca.MSI);
		dao.crearOrdenador(ordenador);
		
	}

	private static void probarConexion() {
		try {
			System.out.println(new Conexion().getConexion());
			System.out.println(new Conexion().getConexion());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
