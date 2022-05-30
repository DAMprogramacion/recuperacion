import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jdbcInicial.modelo.conexion.Conexion;
import jdbcInicial.modelo.dao.Marca;
import jdbcInicial.modelo.dao.Ordenador;
import jdbcInicial.modelo.dao.OrdenadorDAO;
import jdbcInicial.modelo.dao.OrdenadorDAOImpl;
import jdbcInicial.modelo.dao.OrdenadorDAOImplDS;
import jdbcInicial.modelo.dao.TipoDisco;

public class Test {
	private static final OrdenadorDAO dao = new OrdenadorDAOImplDS();
	public static void main(String[] args) {
//		probarConexion();
		crearOrdenador();
		listarTodosLosOrdenadores();
		borrarOrdenador();
		listarTodosLosOrdenadores();
		actualizarOrdenador();
		listarTodosLosOrdenadores();
		
	}

	private static void actualizarOrdenador() {
		Ordenador ordenador = new Ordenador( 20, 20, 20,
				TipoDisco.OTRO, Marca.HP);
		dao.actualizarOrdenador(1, ordenador);
		
	}

	private static void borrarOrdenador() {
		boolean borrado = dao.borrarOrdenador(5);
		System.out.printf("Borrado ? %B%n", borrado);
		
	}

	private static void listarTodosLosOrdenadores() {
		List<Ordenador> lista = dao.obtenerTodosOrdenadores();
		lista.forEach(System.out::println);
	}

	private static void crearOrdenador() {
		Ordenador ordenador = new Ordenador(12, 4f, 256,
				TipoDisco.SOLIDO, Marca.HP);
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
