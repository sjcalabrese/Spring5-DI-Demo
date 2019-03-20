package guru.springframework.controller;

import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller
public class ConstructorInjectedController {
	private GreetingService greetingService;
	
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
