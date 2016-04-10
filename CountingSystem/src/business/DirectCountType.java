package business;

import java.util.List;

import model.Voto;
import util.Dictionary;
import util.IDictionary;

/**
 * Tipo de recuento utilizado en referendums y
 * otras elecciones de correspondencia directa
 * entre votos y resultado
 */
public class DirectCountType implements ICountType {

	@Override
	public IDictionary<Voto, Integer> count(List<Voto> source) {
		
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
		
		if(str.contains("SI"))
			return "green";
		if(str.contains("NO"))
			return "red";
		if(str.contains("BLANCO"))
			return "grey";
		return "grey";
	}
}