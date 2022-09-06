package co.kevingomez.jacksondemo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
 * 
 * You cannot have multiple JsonAnyGettersAnnotations just one and it basically just outputs the entire map into the output
 * @JsonGetter is used on a getter method to basically just change the name most of the time JsonGetter(value="newvalue")
 *   allows a getter method to return Map which is then used to serialize the additional properties of JSON in the similar fashion as other properties.
 *   
 * */
public class JSONAnyGetterDemo {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		Store s1 = new Store();
		s1.addMattress("1", "King Size Mattress");
		s1.addEmployee("1", "Jericho");
		s1.addMattress("3", "Queen size");
		s1.setName("Kevin");
		s1.setLastName("Gomez");
		Car c = new Car();
		c.setAge(12);
		c.setMake("Toyota");
		c.setModel("Rav4");
		s1.setC(c);
		// if this field was not a raw value then the actual escaped characters would be
		// in the output, whereas here its parsing the string as a raw json val
		s1.setDob("{\"raw\": \"kevin\" }");
		String store = mapper.writeValueAsString(s1);

		System.out.println(store);
	}
}

//@JsonPropertyOrder#alphabetic attribute can be used to order elements alphabetically. Here's the example: @JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder(alphabetic = true)
@JsonRootName(value = "store")
class Store implements Serializable {
	private static final long serialVersionUID = 5116453718416519790L;
	Map<String, String> mattresses;
	Map<String, String> employees;
	private Car c;
	@JsonGetter(value="car")
	public Car getC() {
		return c;
	}

	public void setC(Car c) {
		this.c = c;
	}

	private String lastName;
	@JsonRawValue
	public String dob;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

//	@JsonValue will make it so when its turned to json only this value will be returned
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String name;

	public Store() {
		mattresses = new HashMap<>();
		employees = new HashMap<>();
	}

	public void addMattress(String id, String value) {
		mattresses.put(id, value);
	}

	// @JsonAnyGetter
	public Map<String, String> getMattresses() {
		return mattresses;
	}

	public void addEmployee(String id, String value) {
		employees.put(id, value);
	}

	Map<String, String> getEmployees() {
		return employees;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @JsonGetter(value="name")
	public String getName() {
		return this.name;
	}
}

@JsonRootName(value = "car")
class Car {
	int age;
	String make;
	String model;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}