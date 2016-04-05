package persistence;

import java.util.List;

import model.Voto;

public interface IPersistenceSupplier {
	/**
	 * Devuelve una lista de los votos actuales
	 */
	public List<Voto> readResults();
	/**
	 * Devuelve algo con datos necesarios para
	 * calcular estadísticas
	 */
	public Object readStatistics();
}
