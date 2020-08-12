package dataprocessinganalysisformats.summary;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import dataprocessinganalysisformats.comparator.ComparatorPiorVendedor;
import dataprocessinganalysisformats.model.Customer;
import dataprocessinganalysisformats.model.Sale;
import dataprocessinganalysisformats.model.Salesman;
import dataprocessinganalysisformats.model.SummaryImport;

public class ProcessSummaryFile {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessSummaryFile.class);
	Gson gson = new Gson();

	public SummaryImport summaryProcess(Object arquivo) {

		LOGGER.info(" >> sumaryProcess");

		
		String returnLayout = this.validationLayout(arquivo);

		SummaryImport summary = new SummaryImport();
		// summary.setPiorVendedor(this.getWorstSalesman(arquivo));
		summary.setPiorVendedor(returnLayout);

		LOGGER.info(" << sumaryProcess");

		return summary;

	}

	/**
	 * Recupera o pior vendedor
	 * 
	 * @return String nome do vendedor
	 */
	public String validationLayout(Object arquivo) {

		try {

			LOGGER.info(" >>  verifica layout");

			StringBuilder str = new StringBuilder();
		    Integer	contadorSalesman = 0;
		    Integer	contadorSale = 0;
		    Integer	contadorCustomer = 0;

			Salesman salesman = gson.fromJson(arquivo.toString(), Salesman.class);
			Sale sale = gson.fromJson(arquivo.toString(), Sale.class);
			Customer customer = gson.fromJson(arquivo.toString(), Customer.class);

			if (salesman.getCpf() != null) {
				str.append(salesman);
				str.append("salesman:::"+ contadorSalesman++);
			} else if (sale.getId() != null) {
				str.append(sale);
				str.append("sale:::"+ contadorSale++);

				//{"id":"10","saleItems":[
				 //{"id":1,"price":100,"quantity":10},
				 //{"id":2,"price":2.50,"quantity":30},
				 //{"id":3,"price":3.10,"quantity":40}],
				//"salesmanName":"Pedro"}
			} else if (customer.getCnpj() != null) {
				str.append(customer);
				str.append("customer:::"+ contadorCustomer++);

			}

			LOGGER.info(" << retorna layout");

			return str.toString();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
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
		return null;// vendasVendedor;
	}
}
