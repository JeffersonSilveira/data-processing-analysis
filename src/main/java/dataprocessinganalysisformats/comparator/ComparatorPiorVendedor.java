package dataprocessinganalysisformats.comparator;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map.Entry;

public class ComparatorPiorVendedor implements Comparator<Entry<String, BigDecimal>> {

	@Override
	public int compare(Entry<String, BigDecimal> pior, Entry<String, BigDecimal> piorProx) {
		return pior.getValue().compareTo(piorProx.getValue());
	}

}
