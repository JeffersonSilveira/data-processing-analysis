package dataprocessinganalysisformats.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dataprocessinganalysisformats.model.Salesman;

@Configuration
public class ReadingFileMultipleFormatsStepConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadingFileMultipleFormatsStepConfig.class);

	public StepBuilderFactory stepBuilderFactory;

	public ReadingFileMultipleFormatsStepConfig(StepBuilderFactory stepBuilderFactory) {
		super();
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Step readingMultipleFormatsFileStep(
			FlatFileItemReader readingMultipleFormatFilesReader,
			ItemProcessor validationProcessor,
			ItemWriter readingMultipleFormatFilesItemWriter) {

		LOGGER.info("<<<<< Run Step...");

		return stepBuilderFactory.get("leituraArquivoMultiplosFormatosStep")
				.chunk(1)
				.reader(readingMultipleFormatFilesReader)
				.processor(validationProcessor)
				.writer(readingMultipleFormatFilesItemWriter)
				.build();
	}
}
