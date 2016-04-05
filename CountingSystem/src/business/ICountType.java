package business;

import java.util.List;

import model.Voto;
import util.IDictionary;

public interface ICountType {
	public IDictionary<Voto, Integer> count(List<Voto> source);
}
