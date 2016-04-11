package business;

import java.util.List;

import util.IDictionary;
import util.KeyValuePair;

public interface IStatisticType {
	/**
	 * Consigue las estadísticas de la votación actual
	 * @param usefulData Datos útiles para crear las estadísticas, o null
	 * @return Estructura de datos con estadísticas
	 */
	public List<IDictionary<KeyValuePair<String, String>, Integer>> conjure(Object usefulData);
	/**
	 * Devuelve el índice actual de participación
	 * @param usefulData Datos útiles para crear las estadísticas, o null
	 */
	public int getIndiceParticipacion(Object usefulData);
}
