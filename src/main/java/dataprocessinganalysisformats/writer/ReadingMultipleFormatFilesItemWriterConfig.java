package dataprocessinganalysisformats.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReadingMultipleFormatFilesItemWriterConfig {

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

				StringBuilder str = new StringBuilder();
				str.append(item);

				return str.toString();
			}

		};
	}
}
