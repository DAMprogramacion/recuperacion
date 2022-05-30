package extra;

import jdbcInicial.modelo.dao.Marca;
import jdbcInicial.modelo.dao.TipoDisco;

public class Helper {
	
	public static TipoDisco getTipoDisco(String tipo) {
		switch (tipo) {
		case "solido":
			return TipoDisco.SOLIDO;
		case "magnetico":
			return TipoDisco.MAGNETICO;
		default:
			return TipoDisco.OTRO;
		}
	}
	
	public static Marca getMarca(String marca) {
		switch (marca) {
		case "msi":
			return Marca.MSI;
		case "hp":
			return Marca.HP;
		case "asus":
			return Marca.ASUS;
		case "lenovo":
			return Marca.LENOVO;
		default:
			return null;
		}
	}

}
