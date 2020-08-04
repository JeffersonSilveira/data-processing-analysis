package dataprocessinganalysisformats.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFormatsReaderFileConfig {
	
	@Value("file:${input.files.location}${input.file.pattern}")
	private Resource inputResource;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@StepScope
	@Bean
	public FlatFileItemReader arquivoMultiplosFormatosItemReader(LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder()
				.name("arquivoMultiplosFormatosItemReader")
				.resource(inputResource)
				.addComment("--")
				.linesToSkip(1)
				.lineMapper(lineMapper)
				.build();
	}

}
