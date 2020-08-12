package dataprocessinganalysisformats.writer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;

import dataprocessinganalysisformats.model.Salesman;

@Configuration
public class ReadingMultipleFormatFilesItemWriterConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadingMultipleFormatFilesItemWriterConfig.class);

	@Value("file:${input.files.location}${input.file.pattern.out}")
	private Resource outputResource;
	
	Gson gson = new Gson();


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter leituraArquivoDelimitadoWriter() {

		return new FlatFileItemWriterBuilder().name("itemWriter").resource(outputResource)
				.lineAggregator(lineAggregator()).build();
	}

	private LineAggregator lineAggregator() {

		LineAggregator lineAggregator = new LineAggregator() {
			
			@Override
			public String aggregate(Object arquivo) {
				
				StringBuilder str = new StringBuilder();
				str.append(arquivo);
			
				Salesman salesman = gson.fromJson(arquivo.toString(), Salesman.class);
				
				List<String> list = Arrays.asList(arquivo.toString());
				List<String> answer = list.stream().map(String::toLowerCase).collect(Collectors.toList());
				return "Texto aqui:::"+str.toString();
			}
		};

		return lineAggregator;
	}
}
