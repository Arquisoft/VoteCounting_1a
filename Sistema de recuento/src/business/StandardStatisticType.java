package business;

import java.util.List;

import persistence.IPersistenceSupplier;
import util.IDictionary;
import util.KeyValuePair;

/**
 * Estadísticas estándar
 */
public class StandardStatisticType implements IStatisticType {

	@Override
	public List<IDictionary<KeyValuePair<String, String>, Integer>> conjure(Object usefulData) {
		IPersistenceSupplier ips = (IPersistenceSupplier) usefulData;
		return ips.readStatistics();
	}

	@Override
	public int getIndiceParticipacion(Object usefulData) {
		IPersistenceSupplier ips = (IPersistenceSupplier) usefulData;
		return ips.readParticipation();
	}

}
