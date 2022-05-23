package jdbcInicial.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbcInicial.modelo.conexion.Conexion;

public class OrdenadorDAOImpl implements OrdenadorDAO {

	@Override
	public List<Ordenador> obtenerTodosOrdenadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearOrdenador(Ordenador ordenador) {
		int rows = 0;
		PreparedStatement sentencia = null;
		Conexion conexion = null;
		try {
			conexion = new Conexion();
			Connection conecction = new Conexion().getConexion();
			String sql = "INSERT INTO ordenadores (ram, cpu, capacidadDisco, tipoDisco, marca)"
					+ " VALUES (?, ?, ?, ?, ?);";
			sentencia = conecction.prepareStatement(sql);
			sentencia.setInt(1, ordenador.getRam());
			sentencia.setFloat(2, ordenador.getCpu());
			sentencia.setInt(3, ordenador.getCapacidadDisco());
			sentencia.setString(4, ordenador.getTipoDisco().toString().toLowerCase());
			sentencia.setString(5, ordenador.getMarca().toString().toLowerCase());
			rows = sentencia.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (sentencia != null)
						sentencia.close();
					if (conexion != null)
						conexion.cerrarConexion();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rows != 0;
	}

	@Override
	public boolean borrarOrdenador(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarOrdenador(int id, Ordenador ordenador) {
		// TODO Auto-generated method stub
		return false;
	}

}
