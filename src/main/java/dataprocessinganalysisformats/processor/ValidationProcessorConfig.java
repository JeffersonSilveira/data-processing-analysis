package dataprocessinganalysisformats.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dataprocessinganalysisformats.model.Customer;

@Configuration
public class ValidationProcessorConfig {

	@SuppressWarnings("rawtypes")
	@Bean
	public ItemProcessor validationProcessor(){
		BeanValidatingItemProcessor processor = new BeanValidatingItemProcessor<>();
		processor.setFilter(true);
		return processor;		
	}
}
