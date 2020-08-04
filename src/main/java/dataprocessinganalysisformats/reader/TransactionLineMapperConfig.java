package dataprocessinganalysisformats.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dataprocessinganalysisformats.model.Customer;
import dataprocessinganalysisformats.model.Sale;
import dataprocessinganalysisformats.model.SaleItem;
import dataprocessinganalysisformats.model.Salesman;

@Configuration
public class TransactionLineMapperConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(fieldSetMappers());
		return lineMapper;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, FieldSetMapper> fieldSetMappers() {
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
		fieldSetMappers.put("001*", fieldSetMapper(Salesman.class));
		fieldSetMappers.put("002*", fieldSetMapper(Customer.class));
		fieldSetMappers.put("003*", fieldSetMapper(Sale.class));
		fieldSetMappers.put("004*", fieldSetMapper(SaleItem.class));

		return fieldSetMappers;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FieldSetMapper fieldSetMapper(Class classe) {
		BeanWrapperFieldSetMapper filFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		filFieldSetMapper.setTargetType(classe);
		return filFieldSetMapper;
	}

	private Map<String, LineTokenizer> tokenizers() {
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("001*", salesmanLineTokenizer());
		tokenizers.put("002*", customerLineTokenizer());
		tokenizers.put("003*", saleLineTokenizer());
		tokenizers.put("004*", saleLineItemTokenizer());

		return tokenizers;
	}

	private LineTokenizer saleLineItemTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "quantity", "unitPrice");
		lineTokenizer.setDelimiter("-");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;
	}

	private LineTokenizer saleLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id",  "salesmanName");
		lineTokenizer.setDelimiter("ç");
		lineTokenizer.setIncludedFields(1, 2);
		return lineTokenizer;
	}

	private LineTokenizer salesmanLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("cpf", "name", "salary");
		lineTokenizer.setDelimiter("ç");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;
	}

	private LineTokenizer customerLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("cnpj", "name", "businessArea");
		lineTokenizer.setDelimiter("ç");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;

	}
}
