package business;

import java.util.List;

import model.Option;
import model.Voto;
import util.IDictionary;

public interface ICountType {
	public IDictionary<Option, Number> count(List<Voto> source);
}
