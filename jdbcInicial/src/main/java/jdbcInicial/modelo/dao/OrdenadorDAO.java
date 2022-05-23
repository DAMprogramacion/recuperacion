package jdbcInicial.modelo.dao;

import java.util.List;

public interface OrdenadorDAO {
	List<Ordenador> obtenerTodosOrdenadores();
	boolean crearOrdenador(Ordenador ordenador);
	boolean borrarOrdenador(int id);
	boolean actualizarOrdenador(int id, Ordenador ordenador);
}
