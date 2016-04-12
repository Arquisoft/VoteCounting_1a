package persistence;

import java.util.List;

import util.IDictionary;
import util.KeyValuePair;

public interface IPersistenceSupplier {
	/**
	 * Devuelve una lista de los votos actuales
	 */
	public List<KeyValuePair<String, Integer>> readResults();
	/**
	 * Devuelve algo con datos necesarios para
	 * calcular estadísticas
	 */
	public List<IDictionary<KeyValuePair<String, String>, Integer>> readStatistics();
	/**
	 * Devuelve el porcentaje de participación
	 */
	public int readParticipation();
}
