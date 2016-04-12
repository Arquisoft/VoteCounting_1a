package business;

import java.util.List;

import model.Voto;
import util.IDictionary;
import util.KeyValuePair;

public interface ICountType {
	public IDictionary<String, Integer> count(List<KeyValuePair<String, Integer>> source);
	/**
	 * Encuentra el color m�s apropiado para cada opci�n
	 * @param opcion Opci�n
	 * @return Aproximaci�n del color m�s apropiado
	 */
	public String findLikelyColour(String opcion);
}
