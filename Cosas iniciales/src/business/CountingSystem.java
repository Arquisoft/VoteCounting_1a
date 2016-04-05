package business;

import java.util.ArrayList;
import java.util.List;

import model.Option;
import model.Voto;
import persistence.FakePersistenceSupplier;
import persistence.IPersistenceSupplier;
import util.Dictionary;
import util.IDictionary;

public class CountingSystem {
	private ICountType ctype;
	private IPersistenceSupplier psupplier;

	private static final Class<? extends ICountType> defaultCountType = 
			DirectCountType.class;
	private static final Class<? extends IPersistenceSupplier> defaultPersistenceSupplier =
			FakePersistenceSupplier.class;

	/**
	 * Inicializa un nuevo CountingSystem con un Count Type y Persistence
	 * Supplier determinados
	 */
	public CountingSystem(ICountType ctype, IPersistenceSupplier psupplier) {
		this.ctype = ctype;
		this.psupplier = psupplier;
	}

	/**
	 * Inicializa un nuevo CountingSystem con un Count Type y
	 * PersistenceSupplier por defecto
	 */
	public CountingSystem() {
		// Intentar instanciar el Count Type por defecto
		try {
			this.ctype = defaultCountType.newInstance();
			// Si falla, crear uno sobre la marcha que no haga nada
		} catch (Throwable t) {
			this.ctype = new ICountType() {

				@Override
				public IDictionary<Option, Number> count(List<Voto> source) {
					return new Dictionary<>();
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
				public Object readStatistics() {
					return null; // De todas formas, no se usa aquí
				}

				@Override
				public List<Voto> readResults() {
					return new ArrayList<>();
				}
			};
		}
	}

	/**
	 * Recupera, cuenta y devuelve los votos actuales
	 */
	public IDictionary<Option, Number> count() {
		List<Voto> votos = psupplier.readResults();
		// TODO ¿Comprobar algo con los votos?
		return ctype.count(votos);
	}
}
