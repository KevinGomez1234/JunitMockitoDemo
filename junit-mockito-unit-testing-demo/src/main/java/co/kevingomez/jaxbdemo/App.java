package co.kevingomez.jaxbdemo;

import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
public class App 
{
    public static void main( String[] args )
    {
    	Person p = new Person();
    	Car c = new Car();
    	c.setModel("Toyota");
    	c.setYear(1990);
    	
    	p.setAge(23);
    	p.setFirstName("Kevin");
    	p.setLastName("Gomez");
    	p.setCar(c);
    	
    	try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(p, new File("src/main/resources/output.xml"));
			serializePayload(p);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
    }
    
    //literally turns the xml document to binary data... 
    public static void serializePayload(Person p) throws JAXBException {
    	JAXBContext context = JAXBContext.newInstance(Person.class);
    	final Marshaller marshaller = context.createMarshaller();
    	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	marshaller.marshal(p, baos);
    	System.out.println(baos.size());
    }
}
