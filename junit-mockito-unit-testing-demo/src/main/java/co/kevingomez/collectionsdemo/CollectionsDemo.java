package co.kevingomez.collectionsdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CollectionsDemo {
	public static void main(String[] args) {
    	Car toyotaRav4 = new Car("Toyota", "Rav4");
    	Car hondaCivic = new Car("Honda", "Civic");
    	Car zephyr = new Car("Tesla", "Model S");
    	List<Car> kevinsCars = Arrays.asList(hondaCivic, zephyr, toyotaRav4);
    	Person kevin = new Person("Kevin", "Gomez");
    	kevin.setCars(kevinsCars);
    	System.out.println("The cars: " + kevinsCars);
    	Optional<List<Car>> cars = kevin.getCarsByAlphabeticalOrder(kevinsCars);
    	if(!cars.isEmpty())
    		System.out.println("In alphabetical order: " + cars.get().toString());
	}
}
