package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.Greeting;
import mx.tec.lab.dto.Goodbye;


@RestController 
public class GreetingRestController {
	private static final String template1 = "Hello, %s!";
	private static final String template2 = "Bye, %s!";

	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template1, name));
		}
	

	@GetMapping("/goodbye")
	public Goodbye goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Goodbye(counter.incrementAndGet(), String.format(template2, name));
		}
	}

