package co.kevingomez;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import co.kevingomez.controller.HomeController;
/*
 *  A nice feature of the Spring Test support is that the application context is cached between tests. That way, if you have multiple methods in a test case or multiple test cases with the same configuration, they incur the cost of starting the application only once. You can control the cache by using the @DirtiesContext annotation. 
 * */

@SpringBootTest
public class ApplicationITTest {
	@Autowired
	HomeController home;
	@Autowired
	RestTemplate restTemplate;
	@Test
	public void testApplicationContext() {
		assertThat(home).isNotNull();
	}
	@Test
	public void testRestController() {
		String home = home.home();
	}
	
	
}
