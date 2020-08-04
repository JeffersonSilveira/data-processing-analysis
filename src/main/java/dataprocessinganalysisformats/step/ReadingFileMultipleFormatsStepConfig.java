package dataprocessinganalysisformats.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dataprocessinganalysisformats.job.MultipleFormatsFileJobConfig;

@Configuration
public class ReadingFileMultipleFormatsStepConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadingFileMultipleFormatsStepConfig.class);
		
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Step readingMultipleFormatsFileStep(
			FlatFileItemReader readingMultipleFormatFilesReader,
			ItemWriter readingMultipleFormatFilesItemWriter) {
		
		LOGGER.info("<<<<< Run Step...");
		
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.chunk(1)
				.reader(readingMultipleFormatFilesReader)
				.writer(readingMultipleFormatFilesItemWriter)
				.build();
	}
}
