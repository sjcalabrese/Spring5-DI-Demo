package guru.springframework.controller;

import guru.springframework.services.GreetingServiceImpl;

public class PropertyInjectedController {
	
	public GreetingServiceImpl greetingService;
	
	String sayHello() {
		return greetingService.sayGreeting();
	}
	
	
}
