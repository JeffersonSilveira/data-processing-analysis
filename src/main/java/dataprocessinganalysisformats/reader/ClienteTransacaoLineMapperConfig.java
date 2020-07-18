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

import dataprocessinganalysisformats.dominio.Customer;

@Configuration
public class ClienteTransacaoLineMapperConfig {

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
//		fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
//		fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));
		fieldSetMappers.put("2*", fieldSetMapper(Customer.class));

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
//		tokenizers.put("0*",  clienteLineTokenizer());
//		tokenizers.put("1*",  transacaoLineTokenizer());
		tokenizers.put("2*", customerLineTokenizer());

		return tokenizers;
	}

	private LineTokenizer customerLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("cnpj", "name", "businessArea");
		lineTokenizer.setDelimiter("ç");		
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;

	}

	private LineTokenizer clienteLineTokenizer() {

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);
		return lineTokenizer;
	}

	private LineTokenizer transacaoLineTokenizer() {

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "descricao", "valor");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;
	}

}
