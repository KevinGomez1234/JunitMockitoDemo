package co.kevingomez.collectionsdemo;

import java.util.List;
import java.util.Optional;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private List<Car> cars;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Optional<List<Car>> getCarsByAlphabeticalOrder(List<Car> cars) {
		if (!cars.isEmpty()) {
			java.util.Collections.sort(cars);
			return Optional.of(cars);
		}
		return Optional.empty();
	}

}
