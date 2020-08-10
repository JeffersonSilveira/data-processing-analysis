package dataprocessinganalysisformats.summary;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import dataprocessinganalysisformats.comparator.ComparatorPiorVendedor;
import dataprocessinganalysisformats.model.Sale;
import dataprocessinganalysisformats.model.Salesman;
import dataprocessinganalysisformats.model.SummaryImport;

public class ProcessSummaryFile {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessSummaryFile.class);
	Gson gson = new Gson();


	public SummaryImport summaryProcess(Object arquivo) {
		LOGGER.info(" >> sumaryProcess");
		
		this.validationLayout(arquivo);
		
		SummaryImport summary = new SummaryImport();
		summary.setPiorVendedor(this.getWorstSalesman(arquivo));

		LOGGER.info(" << sumaryProcess");

		return summary;

	}
	
	/**
	 * Recupera o pior vendedor
	 * 
	 * @return String nome do vendedor
	 */
	private String validationLayout(Object arquivo) {
		LOGGER.info(" >>  verifica layout");

		Salesman salesman = gson.fromJson(arquivo.toString(), Salesman.class);
		
		Sale     sale     = gson.fromJson(arquivo.toString(), Sale.class);

		LOGGER.info(" << retorna layout");
		return "";
	}

	
	/**
	 * Recupera o pior vendedor
	 * 
	 * @return String nome do vendedor
	 */
	private String getWorstSalesman(Object arquivo) {
		LOGGER.info(" >> obterPiorVendedor");

		Map<String, BigDecimal> vendasVendedor = this.summaryVenda(arquivo);

		Entry<String, BigDecimal> piorVendedor = null;
		if (!vendasVendedor.isEmpty()) {
			piorVendedor = Collections.min(vendasVendedor.entrySet(), new ComparatorPiorVendedor());
		}

		LOGGER.info(" << obterPiorVendedor");
		return piorVendedor != null ? piorVendedor.getKey() : "";
	}

	private Map<String, BigDecimal> summaryVenda(Object arquivo) {
		LOGGER.info(" >> summaryVenda");
		
		Gson gson = new Gson();

		Salesman obj = gson.fromJson(arquivo.toString(), Salesman.class);

		LOGGER.info(" << summaryVenda");
		return null;//vendasVendedor;
	}
}
