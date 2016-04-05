package business;

import java.util.List;
import java.util.stream.Collectors;

import model.Option;
import model.Voto;
import util.Dictionary;
import util.IDictionary;
import util.KeyValuePair;

public class DirectCountType implements ICountType {

	@Override
	public IDictionary<Option, Number> count(List<Voto> source) {
		
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
		
		// Convierte el diccionario Partido-Num. votos en una lista de KVP Opción-Num. votos
		List<KeyValuePair<Option, ? extends Number>> result = distri.stream().map((vip) -> {
			Option opt = new Option(vip.key.getPartido().toString());
			return new KeyValuePair<>(opt, vip.value);
		}).collect(Collectors.toList());
		
		// Crea un diccionario Opcion-Num. votos
		IDictionary<Option, Number> trueResult = new Dictionary<>();
		result.forEach(kvp -> {
			trueResult.put(kvp.key, kvp.value.intValue());
		});
		
		return trueResult;
	}

}
