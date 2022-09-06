package co.kevingomez.person;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PersonClient {

	public Optional<Person> getPerson() {
		RestTemplate restTemplate = new RestTemplate();
		Person p = restTemplate.getForObject("http://192.168.0.13/index.php", Person.class);
		if(p != null) {
			return Optional.of(p);
		}
		return Optional.empty();
//		System.out.println(p.name);
//		p.name = "Kevin";
//		HttpEntity<Person> req = request(p);
//		Person echoPerson = restTemplate.postForObject("http://192.168.0.13/index.php", req, Person.class);
//		System.out.println(echoPerson.name);
		
	}
	
	//HttpEntity takes in the HttpRequest and Headers you can accept a list of MediaTypes but only send out a single request
	public HttpEntity<Person> request(Person p){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_XML));
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_XML);
		return new HttpEntity<>(p, headers); 
	}
	
	
}
