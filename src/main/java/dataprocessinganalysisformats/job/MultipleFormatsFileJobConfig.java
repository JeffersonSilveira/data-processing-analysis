package dataprocessinganalysisformats.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableBatchProcessing
@Configuration
public class MultipleFormatsFileJobConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MultipleFormatsFileJobConfig.class);
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job multipleFormatsfileJob(Step readingMultipleFormatsFileStep) {
		
		LOGGER.info("<<<<< Run Job...");

		return jobBuilderFactory
				.get("multipleFormatsfileJob")
				.start(readingMultipleFormatsFileStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
