package co.kevingomez.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kevingomez.person.Person;
import co.kevingomez.person.PersonClient;
/*
 * A controller is a class that handles requests and responds with some sort of information
 * */
@RestController
public class HomeController {
	private final PersonClient personClient;
	
	public HomeController(PersonClient personClient) {
		this.personClient = new PersonClient();
	}
	
	@GetMapping("/")
	public String home() {
		Optional<Person> person = personClient.getPerson();
		if(person.isEmpty()) {
			return "Home";
		} else {
			return person.get().name;
		}
	}
}
