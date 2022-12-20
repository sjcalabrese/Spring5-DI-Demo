package guru.springframework.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */
@Service
public class PrimaryGermanGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayGreeting() {
		return greetingRepository.getGermanGreeting();
	}
}