package dataprocessinganalysisformats.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import dataprocessinganalysisformats.model.SummaryImport;
import dataprocessinganalysisformats.summary.ProcessSummaryFile;

@Configuration
public class ReadingMultipleFormatFilesItemWriterConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadingMultipleFormatFilesItemWriterConfig.class);

	@Value("file:${input.files.location}${input.file.pattern.out}")
	private Resource outputResource;

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter leituraArquivoDelimitadoWriter() {

		return new FlatFileItemWriterBuilder().name("itemWriter").resource(outputResource)
				.lineAggregator(lineAggregator()).build();
	}

	private LineAggregator lineAggregator() {

		return new LineAggregator() {
		
			
			@Override
			public String aggregate(Object item) {

				LOGGER.info("Sumarizando informações...");
				ProcessSummaryFile processSummaryFile = new ProcessSummaryFile(); 
				SummaryImport summary = processSummaryFile.summaryProcess(item);

				return summary.getPiorVendedor().toString();
			}

		};
	}
}
