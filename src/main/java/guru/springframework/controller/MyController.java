package guru.springframework.controller;

import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller
public class MyController {
	
	private GreetingService greetingService;
	
	
	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}


	public String hello() {
		System.out.println("hello");
		
		return greetingService.sayGreeting();
	}

}
