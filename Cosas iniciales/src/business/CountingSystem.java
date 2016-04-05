package business;

import java.util.ArrayList;
import java.util.List;

import model.Voto;
import persistence.FakePersistenceSupplier;
import persistence.IPersistenceSupplier;
import util.Dictionary;
import util.IDictionary;

public class CountingSystem {
	/* Atributos de la clase */
	private ICountType ctype;
	private IPersistenceSupplier psupplier;

	/* Clases por defecto para los atributos de la clase */
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
				public IDictionary<Voto, Integer> count(List<Voto> source) {
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
	public IDictionary<Voto, Integer> count() {
		List<Voto> votos = psupplier.readResults();
		
		// Asignar un color apropiado a cada voto
		votos.forEach((voto) -> voto.setPreferredColor(findLikelyColour(voto.getOpcion())));
		
		return ctype.count(votos);
	}
	
	/**
	 * Encuentra el color más apropiado para cada opción
	 * @param opcion Opción
	 * @return Aproximación del color más apropiado
	 */
	private String findLikelyColour(String opcion) {
		String str = opcion.toUpperCase();
		
		if(str.contains("PP") || str.contains("POPULAR"))
			return "blue";
		if(str.contains("PS") || str.contains("SOCIALISTA"))
			return "red";
		if((str.contains("CIU") && str.length() > 3) || str.contains("C'S"))
			return "orange";
		if(str.contains("PODEM") || str.contains("AHORA") || str.contains("MAREA"))
			return "purple";
		if(str.contains("UNIDA") || str.contains("IU"))
			return "green";
		return "grey";
	}
}
