package common;

import business.CountingSystem;
import business.DirectCountType;
import model.Voto;
import persistence.JdbcPersistenceSupplier;
import util.IDictionary;
import util.KeyValuePair;

public class DebugExecution {

	public static void main(String[] args) {
		CountingSystem cs = new CountingSystem();
		
		IDictionary<Voto, Integer> votos = cs.count();
		
		System.out.println("\tVotos contados (Base de datos de a bulto):");
		votos.forEach(DebugExecution::printKVP);
		
		System.out.print("\tVotos al PP: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.getOpcion().equals("PP")).findFirst().get().value);
		System.out.print("\tVotos al PSOE: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.getOpcion().equals("PSOE")).findFirst().get().value);
		System.out.print("\tVotos en BLANCO: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.getOpcion().equals("BLANCO")).findFirst().get().value);
		
		
		CountingSystem sc = new CountingSystem(new DirectCountType(), new JdbcPersistenceSupplier());
		
		IDictionary<Voto, Integer> sotov = sc.count();
		
		System.out.println("\tVotos contados (Base de datos real):");
		sotov.forEach(DebugExecution::printKVP);
		
		System.out.print("\tVotos al SI: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.getOpcion().equals("SI")).findFirst().get().value);
		System.out.print("\tVotos al NO: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.getOpcion().equals("NO")).findFirst().get().value);
		System.out.print("\tVotos en BLANCO: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.getOpcion().equals("BLANCO")).findFirst().get().value);
	}

	private static void printKVP(KeyValuePair<Voto, Integer> kvp) {
		System.out.println(kvp.toString());
	}
}
