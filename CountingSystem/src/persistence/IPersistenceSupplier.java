package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Voto;

public interface IPersistenceSupplier {
	/**
	 * Devuelve una lista de los votos actuales
	 * @throws SQLException 
	 */
	public List<Voto> readResults() throws SQLException;
	/**
	 * Devuelve algo con datos necesarios para
	 * calcular estadísticas
	 * @throws SQLException 
	 */
	public Object readStatistics() throws SQLException;
	
	public int participation() throws SQLException;
}
