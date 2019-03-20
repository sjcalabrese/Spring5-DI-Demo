package guru.springframework.services;


import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
	
	public static final String HELLO_GURUS = "Hello Gurus!!! - original impl";
	
	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return HELLO_GURUS;
	}

}
