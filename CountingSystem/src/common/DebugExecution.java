package common;

import java.util.List;

import business.CountingSystem;
import business.DirectCountType;
import business.StandardStatisticType;
import business.StatisticsSystem;
import model.Voto;
import persistence.JdbcPersistenceSupplier;
import util.IDictionary;
import util.KeyValuePair;

public class DebugExecution {

	public static void main(String[] args) {
		CountingSystem cs = new CountingSystem();
		
		IDictionary<String, Integer> votos = cs.count();
		
		System.out.println("\tVotos contados (Base de datos de a bulto):");
		votos.forEach(DebugExecution::printKVP);
		
		System.out.print("\tVotos al PP: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.equals("PP")).findFirst().get().value);
		System.out.print("\tVotos al PSOE: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.equals("PSOE")).findFirst().get().value);
		System.out.print("\tVotos en BLANCO: ");
		System.out.println(votos.stream().filter(kvp -> kvp.key.equals("BLANCO")).findFirst().get().value);
		
		
		CountingSystem sc = new CountingSystem(new DirectCountType(), new JdbcPersistenceSupplier());
		
		IDictionary<String, Integer> sotov = sc.count();
		
		System.out.println("\tVotos contados (Base de datos real):");
		sotov.forEach(DebugExecution::printKVP);
		
		System.out.print("\tVotos al SI: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.equals("SI")).findFirst().get().value);
		System.out.print("\tVotos al NO: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.equals("NO")).findFirst().get().value);
		System.out.print("\tVotos en BLANCO: ");
		System.out.println(sotov.stream().filter(kvp -> kvp.key.equals("BLANCO")).findFirst().get().value);
		
		StatisticsSystem ss = new StatisticsSystem(new StandardStatisticType(), new JdbcPersistenceSupplier());
		System.out.println(ss.getParticipacion());
		ss.getEstadisticas().stream().sorted((dic1, dic2) -> dic1.keys().get(0).key.compareTo(dic2.keys().get(0).key)).forEach(DebugExecution::printCosaGrande);
		
	}

	private static void printKVP(KeyValuePair<String, Integer> kvp) {
		System.out.println(kvp.toString());
	}
	
	private static void printCosaGrande(IDictionary<KeyValuePair<String, String>, Integer> cosaGrande) {
		cosaGrande.forEach(kvp -> {
			System.out.println("Ciudad: " + kvp.key.key + ". Opción: " + kvp.key.value + ". NumVotos: " + kvp.value);
		});
	}
}
