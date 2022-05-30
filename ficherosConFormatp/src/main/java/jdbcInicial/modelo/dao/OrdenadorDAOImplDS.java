package jdbcInicial.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extra.Helper;
import jdbcInicial.modelo.conexion.Conexion;
import jdbcInicial.modelo.conexion.ConexionPool;

public class OrdenadorDAOImplDS implements OrdenadorDAO {

	@Override
	public List<Ordenador> obtenerTodosOrdenadores() {
		// TODO Auto-generated method stub
		List<Ordenador> lista = new ArrayList<Ordenador>();
		ResultSet resultado = null;
		Statement sentencia = null;
		Connection connection = null;
		try {
			
			connection = ConexionPool.getConnection();
			String sql = "SELECT * FROM ordenadores; ";
			sentencia = connection.createStatement();
			resultado = sentencia.executeQuery(sql);
			while (resultado.next()){
				int   ram           = resultado.getInt("ram");
				float cpu           = resultado.getFloat("cpu");
				int capacidadDisco  = resultado.getInt("capacidadDisco");
				String sTipoDisco   = resultado.getString("tipoDisco");
				TipoDisco tipoDisco = Helper.getTipoDisco(sTipoDisco);
				String sMarca       = resultado.getString("marca");
				Marca marca         = Helper.getMarca(sMarca);
				Ordenador ordenador = 
						new Ordenador(ram, cpu, capacidadDisco, tipoDisco, marca);;
				lista.add(ordenador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultado != null)
				try {
					resultado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (sentencia != null)
				try {
					sentencia.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ConexionPool.cerrarConexion(connection);
		}
		return lista;
	}

	@Override
	public boolean crearOrdenador(Ordenador ordenador) {
		int rows = 0;
		PreparedStatement sentencia = null;
		Connection connection = null;
		try {
			connection = ConexionPool.getConnection();
			String sql = "INSERT INTO ordenadores (ram, cpu, capacidadDisco, tipoDisco, marca)"
					+ " VALUES (?, ?, ?, ?, ?);";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, ordenador.getRam());
			sentencia.setFloat(2, ordenador.getCpu());
			sentencia.setInt(3, ordenador.getCapacidadDisco());
			sentencia.setString(4, ordenador.getTipoDisco().toString().toLowerCase());
			sentencia.setString(5, ordenador.getMarca().toString().toLowerCase());
			rows = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (sentencia != null)
						sentencia.close();
				ConexionPool.cerrarConexion(connection);	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rows != 0;
	}

	@Override
	public boolean borrarOrdenador(int id) {
		
		int rows = 0;
		PreparedStatement sentencia = null;
		Connection connection = null;
		try {
			connection = ConexionPool.getConnection();
			String sql = "DELETE FROM ordenadores WHERE id = ?; ";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1,id);
			rows = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (sentencia != null)
						sentencia.close();
				ConexionPool.cerrarConexion(connection);	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rows != 0;
	}

	@Override
	public boolean actualizarOrdenador(int id, Ordenador ordenador) {
		// TODO Auto-generated method stub
		int rows = 0;
		PreparedStatement sentencia = null;
		Connection connection = null;
		try {
			connection = ConexionPool.getConnection();
			String sql = "UPDATE ordenadores SET ram = ?, cpu = ?, capacidadDisco = ?, "
					+ "tipoDisco = ?, marca = ? where id = ?;";

			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, ordenador.getRam());
			sentencia.setFloat(2, ordenador.getCpu());
			sentencia.setInt(3, ordenador.getCapacidadDisco());
			sentencia.setString(4, ordenador.getTipoDisco().toString().toLowerCase());
			sentencia.setString(5, ordenador.getMarca().toString().toLowerCase());
			sentencia.setInt(6, id);
			rows = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (sentencia != null)
						sentencia.close();
					ConexionPool.cerrarConexion(connection);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rows != 0;
	
	}

}
