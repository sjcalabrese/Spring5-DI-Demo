package guru.springframework.controller;

import guru.springframework.services.GreetingService;

public class SetterInjectedController {
	
	private GreetingService greetingService;
	
	String sayHello() {
		return greetingService.sayGreeting();
	}
	
	public void getGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

}
