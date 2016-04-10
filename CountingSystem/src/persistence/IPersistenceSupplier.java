package persistence;

import java.util.List;

import model.Voto;
import util.IDictionary;
import util.KeyValuePair;

public interface IPersistenceSupplier {
	/**
	 * Devuelve una lista de los votos actuales
	 */
	public List<Voto> readResults();
	/**
	 * Devuelve algo con datos necesarios para
	 * calcular estad�sticas
	 */
	public List<IDictionary<KeyValuePair<String, String>, Integer>> readStatistics();
	/**
	 * Devuelve el porcentaje de participaci�n
	 */
	public int readParticipation();
}
