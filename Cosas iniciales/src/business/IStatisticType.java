package business;

import model.Option;
import util.IDictionary;

public interface IStatisticType {
	public IDictionary<Option, Object> conjure(Object usefulData);
}
