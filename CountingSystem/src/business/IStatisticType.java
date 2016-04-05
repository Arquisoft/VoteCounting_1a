package business;

import model.Voto;
import util.IDictionary;

public interface IStatisticType {
	public IDictionary<Voto, Object> conjure(Object usefulData);
}
