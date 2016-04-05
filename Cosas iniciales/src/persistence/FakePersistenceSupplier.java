package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Partidos;
import model.Voto;

public class FakePersistenceSupplier implements IPersistenceSupplier {

	@Override
	public List<Voto> readResults() {
		List<Voto> votos = new ArrayList<>();
		votos.add(new Voto().setPartido(Partidos.PP).setCodColegio(100));
		votos.add(new Voto().setPartido(Partidos.PP).setCodColegio(100));
		votos.add(new Voto().setPartido(Partidos.PSOE).setCodColegio(200));
		votos.add(new Voto().setPartido(Partidos.BLANCO).setCodColegio(200));
		votos.add(new Voto().setPartido(Partidos.PP).setCodColegio(300));
		votos.add(new Voto().setPartido(Partidos.BLANCO).setCodColegio(300));
		votos.add(new Voto().setPartido(Partidos.BLANCO).setCodColegio(100));
		votos.add(new Voto().setPartido(Partidos.PP).setCodColegio(100));
		votos.add(new Voto().setPartido(Partidos.PSOE).setCodColegio(200));
		votos.add(new Voto().setPartido(Partidos.PP).setCodColegio(200));
		votos.add(new Voto().setPartido(Partidos.PSOE).setCodColegio(300));
		votos.add(new Voto().setPartido(Partidos.BLANCO).setCodColegio(300));
		return votos;
	}

	@Override
	public Object readStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

}
