package business;

import java.util.List;

import model.Voto;
import util.IDictionary;

public interface ICountType {
	public IDictionary<Voto, Integer> count(List<Voto> source);
	/**
	 * Encuentra el color m�s apropiado para cada opci�n
	 * @param opcion Opci�n
	 * @return Aproximaci�n del color m�s apropiado
	 */
	public String findLikelyColour(String opcion);
}
