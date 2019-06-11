package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ConstructorGreetingService implements GreetingService {
	
	@Override
	public String sayGreeting() {
		return "Hello - I am injected via the constructor";
	}

}
