package guru.springframework.services;

public class GreetingServiceImpl implements GreetingService {
	
	public static final String HELLO_GURUS = "Hello Gurus!!!";
	
	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return HELLO_GURUS;
	}

}
