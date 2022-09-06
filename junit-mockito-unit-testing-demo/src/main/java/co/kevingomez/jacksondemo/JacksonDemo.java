package co.kevingomez.jacksondemo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa. 
 *  Can be used to serialize/deserialize xml
 * */
public class JacksonDemo {
	final String baseFileDirectory = "src/main/resources/";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PersonD p = new PersonD();
		p.setAge(12);
		p.setDob("12/12/12");
		p.setName("Jevin");
		String json = "{\"age\": 12, \"dob\": \"12/12/12\", \"name\": \"Jevin\"}";
	}

	public PersonD rawJsonStringToObject(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper.readValue(json, PersonD.class);
	}

	// Pojo to JSON String
	public String pojoToJsonString(PersonD person) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper.writeValueAsString(person);
	}

	// Serialization
	public void pojoToFile(PersonD person) throws IOException {
		String fileLocation = baseFileDirectory + "Person.json";
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(fileLocation), person);
	}

	// Deserialization
	public PersonD jsonInFileToObject(String fileName) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(baseFileDirectory + fileName), PersonD.class);
	}
	
	//writing raw binary to a file
}
