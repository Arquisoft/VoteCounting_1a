package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Voto;
import persistence.FakePersistenceSupplier;
import persistence.IPersistenceSupplier;
import util.Dictionary;
import util.IDictionary;
import util.KeyValuePair;

public class StatisticsSystem {
	/* Atributos de la clase */
	private IStatisticType stype;
	private IPersistenceSupplier psupplier;

	/* Clases por defecto para los atributos de la clase */
	private static final Class<? extends IStatisticType> defaultStatisticType = 
			StandardStatisticType.class;
	private static final Class<? extends IPersistenceSupplier> defaultPersistenceSupplier =
			FakePersistenceSupplier.class;

	/**
	 * Inicializa un nuevo CountingSystem con un Count Type y Persistence
	 * Supplier determinados
	 */
	public StatisticsSystem(IStatisticType ctype, IPersistenceSupplier psupplier) {
		this.stype = ctype;
		this.psupplier = psupplier;
	}

	/**
	 * Inicializa un nuevo CountingSystem con un Count Type y
	 * PersistenceSupplier por defecto
	 */
	public StatisticsSystem() {
		// Intentar instanciar el Count Type por defecto
		try {
			this.stype = defaultStatisticType.newInstance();
		// Si falla, crear uno sobre la marcha que no haga nada
		} catch (Throwable t) {
			this.stype = new IStatisticType() {

				@Override
				public List<IDictionary<KeyValuePair<String, String>, Integer>> conjure(
						Object usefulData) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getIndiceParticipacion(Object usefulData) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
		}
		// Intentar instanciar el Persistence Supplier por defecto
		try {
			this.psupplier = defaultPersistenceSupplier.newInstance();
		// Si falla, crear uno sobre la marcha que no haga nada
		} catch (Throwable t) {
			this.psupplier = new IPersistenceSupplier() {

				@Override
				public List<IDictionary<KeyValuePair<String, String>, Integer>> readStatistics() {
					return null; // De todas formas, no se usa aquí
				}

				@Override
				public List<KeyValuePair<String, Integer>> readResults() {
					return new ArrayList<>();
				}

				@Override
				public int readParticipation() {
					return 100;
				}
			};
		}
	}

	/**
	 * Recupera, cuenta y devuelve los votos actuales
	 * @throws SQLException 
	 */
	public List<IDictionary<KeyValuePair<String, String>, Integer>> getEstadisticas() {
		return stype.conjure(this.psupplier);
	}
	
	public int getParticipacion() {
		return psupplier.readParticipation();
	}
	
}
