package business;

import java.util.List;

import model.Voto;
import util.IDictionary;
import util.KeyValuePair;

public interface ICountType {
	public IDictionary<String, Integer> count(List<KeyValuePair<String, Integer>> source);
	/**
	 * Encuentra el color más apropiado para cada opción
	 * @param opcion Opción
	 * @return Aproximación del color más apropiado
	 */
	public String findLikelyColour(String opcion);
}
