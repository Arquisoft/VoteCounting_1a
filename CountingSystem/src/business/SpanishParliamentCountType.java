package business;

import java.util.List;

import model.Voto;
import util.Dictionary;
import util.IDictionary;

/**
 * Tipo de recuento utilizado en las elecciones al
 * parlamento español.
 */
public class SpanishParliamentCountType implements ICountType {

	@Override
	public IDictionary<Voto, Integer> count(List<Voto> source) {
	//TODO ¿Cómo se cuenta?
		IDictionary<Voto, Integer> distri = new Dictionary<>();
		
		// Convertir la lista de votos en un diccionario Partido-Num. votos
		source.stream().parallel().collect(() -> distri, (dic, voto) -> {
			if(dic.containsKey(voto)) {
				int value = dic.get(voto);
				dic.remove(voto);
				dic.put(voto, ++value);
			}
			else {
				dic.put(voto, 1);
			}
		}, (dic1, dic2) -> {
			dic1.putAll(dic2.asList());
		});
		
		return distri;
	}
	
	@Override
	public String findLikelyColour(String opcion) {
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
