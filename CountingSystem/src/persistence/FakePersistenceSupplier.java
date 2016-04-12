package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Voto;
import util.Dictionary;
import util.IDictionary;
import util.KeyValuePair;

public class FakePersistenceSupplier implements IPersistenceSupplier {

	@Override
	public List<Voto> readResults() {
		List<Voto> votos = new ArrayList<>();
		votos.add(new Voto().setOpcion("PP").setCodColegio(100));
		votos.add(new Voto().setOpcion("PP").setCodColegio(100));
		votos.add(new Voto().setOpcion("PSOE").setCodColegio(200));
		votos.add(new Voto().setOpcion("BLANCO").setCodColegio(200));
		votos.add(new Voto().setOpcion("PP").setCodColegio(300));
		votos.add(new Voto().setOpcion("BLANCO").setCodColegio(300));
		votos.add(new Voto().setOpcion("BLANCO").setCodColegio(100));
		votos.add(new Voto().setOpcion("PP").setCodColegio(100));
		votos.add(new Voto().setOpcion("PSOE").setCodColegio(200));
		votos.add(new Voto().setOpcion("PP").setCodColegio(200));
		votos.add(new Voto().setOpcion("PSOE").setCodColegio(300));
		votos.add(new Voto().setOpcion("BLANCO").setCodColegio(300));
		return votos;
	}

	@Override
	public List<IDictionary<KeyValuePair<String, String>, Integer>> readStatistics() {
		return Stream.iterate(
				(IDictionary<KeyValuePair<String, String>, Integer>)null, 
				n -> new Dictionary<KeyValuePair<String, String>, Integer>()
				.put(new KeyValuePair<>("Prueba", "PP"), 5)
				.put(new KeyValuePair<>("Prueba", "PSOE"), 3)
				.put(new KeyValuePair<>("Prueba", "BLANCO"), 4))
				.limit(1)
				.collect(Collectors.toList());
	}

	@Override
	public int readParticipation() {
		return 100;
	}

}
