package guru.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller
public class SetterInjectedController {
	
	@Autowired
	@Qualifier("getterGreetingService")
	private GreetingService greetingService;
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
	public void getGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

}
