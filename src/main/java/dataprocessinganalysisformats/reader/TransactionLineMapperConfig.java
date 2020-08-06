package dataprocessinganalysisformats.reader;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.RegexLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dataprocessinganalysisformats.enumeration.LayoutMatcherRegexEnum;
import dataprocessinganalysisformats.model.Customer;
import dataprocessinganalysisformats.model.Sale;
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
		return tokenizers;
	}
	
	private LineTokenizer saleLineTokenizer() {
		RegexLineTokenizer lineTokenizer = new RegexLineTokenizer();
		lineTokenizer.setNames("id", "saleItems", "salesmanName");
		LayoutMatcherRegexEnum layoutMatcherRegexEnum = LayoutMatcherRegexEnum.SALE;
		lineTokenizer.setPattern(Pattern.compile(layoutMatcherRegexEnum.getRegex()));
		return lineTokenizer;
	}

	private LineTokenizer salesmanLineTokenizer() {
		RegexLineTokenizer lineTokenizer = new RegexLineTokenizer();
		lineTokenizer.setNames("cpf", "name", "salary");
		LayoutMatcherRegexEnum layoutMatcherRegexEnum = LayoutMatcherRegexEnum.SALESMAN;
		lineTokenizer.setPattern(Pattern.compile(layoutMatcherRegexEnum.getRegex()));
		return lineTokenizer;
	}

	private LineTokenizer customerLineTokenizer() {
		RegexLineTokenizer lineTokenizer = new RegexLineTokenizer();
		lineTokenizer.setNames("cnpj", "name", "businessArea");
		LayoutMatcherRegexEnum layoutMatcherRegexEnum = LayoutMatcherRegexEnum.CUSTOMER;
		lineTokenizer.setPattern(Pattern.compile(layoutMatcherRegexEnum.getRegex()));
		return lineTokenizer;
	}
}
