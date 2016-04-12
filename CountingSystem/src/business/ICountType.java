package business;

import java.util.List;

import model.Voto;
import util.IDictionary;

public interface ICountType {
	public IDictionary<Voto, Integer> count(List<Voto> source);
	/**
	 * Encuentra el color más apropiado para cada opción
	 * @param opcion Opción
	 * @return Aproximación del color más apropiado
	 */
	public String findLikelyColour(String opcion);
}
