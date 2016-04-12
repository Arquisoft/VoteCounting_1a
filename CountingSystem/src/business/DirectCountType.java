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
		source.forEach(voto -> {
			Voto outbound = new Voto().setOpcion(voto.getOpcion()).setCodColegio(0)
					.setPreferredColor(voto.getPreferredColor());
			
			if(distri.containsKey(outbound)) {
				int value = distri.get(outbound);
				distri.remove(outbound);
				distri.put(outbound, value+1);
			} else {
				distri.put(outbound, 1);
			}
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
