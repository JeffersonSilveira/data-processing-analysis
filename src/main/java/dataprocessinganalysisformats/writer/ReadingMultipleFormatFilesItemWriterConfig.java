package dataprocessinganalysisformats.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;

import dataprocessinganalysisformats.model.Sale;
import dataprocessinganalysisformats.model.Salesman;
import dataprocessinganalysisformats.summary.ProcessSummaryFile;

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

			public ProcessSummaryFile sumaryImportFile;

			@Override
			public String aggregate(Object item) {
		
				Gson gson = new Gson();

				Salesman salesman = gson.fromJson(item.toString(), Salesman.class);
				Sale     sale     = gson.fromJson(item.toString(), Sale.class);

				StringBuilder str = new StringBuilder();
				str.append(item);

				return str.toString();
			}

		};
	}
}
