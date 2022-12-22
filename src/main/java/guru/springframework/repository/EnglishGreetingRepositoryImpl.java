package guru.springframework.repository;

import org.springframework.stereotype.Repository;

@Repository
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
