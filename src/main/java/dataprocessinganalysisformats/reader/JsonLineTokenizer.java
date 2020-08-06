package dataprocessinganalysisformats.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLineTokenizer extends DelimitedLineTokenizer {

	
//	@Override
//	public FieldSet tokenize(String line) {
//		List<String> tokens = new ArrayList<>();
//		try {
//			HashMap<String, Object> result = new ObjectMapper().readValue(line, HashMap.class);
//			tokens.add((String) result.get("field1"));
//			tokens.add((String) result.get("field2"));
//		} catch (IOException e) {
//			throw new RuntimeException("Unable to parse json: " + line);
//		}
//		return new DefaultFieldSet(tokens.toArray(new String[0]));
//	}

	/*
	 * @Override public FieldSet tokenize(String line) { List<String> tokens = new
	 * ArrayList<>(); try { HashMap<String,Object> result = new
	 * ObjectMapper().readValue(line, HashMap.class); tokens.add((String)
	 * result.get("field1")); tokens.add((String) result.get("field2"))); } catch
	 * (IOException e) { throw new RuntimeException("Unable to parse json: " +
	 * line); } return new DefaultFieldSet(tokens.toArray(new String[0]), {"field1",
	 * "field2"}); }
	 */
}
