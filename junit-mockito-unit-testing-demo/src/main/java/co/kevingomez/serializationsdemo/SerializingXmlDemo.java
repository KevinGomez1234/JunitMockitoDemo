package co.kevingomez.serializationsdemo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/*
 * ObjectMapper serializes java objects, XmlMapper is a subclass of object mapper 
 * */
public class SerializingXmlDemo {
	public static void main(String[] args) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(new SimpleBean());

		xmlMapper.writeValue(new File("src/main/resources/simple_bean.xml"), new SimpleBean());

		File file = new File("src/main/resources/simple_bean.xml");
		// we can also pass a file to readValue...
		SimpleBean value = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
	}

}
