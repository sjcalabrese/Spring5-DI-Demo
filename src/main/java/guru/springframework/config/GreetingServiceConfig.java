package guru.springframework.config;

import com.springframework.pets.DogPetService;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.datasource.FakeDataSource;
import guru.springframework.repository.EnglishGreetingRepository;
import guru.springframework.repository.EnglishGreetingRepositoryImpl;
import guru.springframework.services.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


//@PropertySource("classpath:datasource.properties")
//@ImportResource("classpath:sfgdi-config.xml")
    //this is configuration class and is used to define beans

//Import resource allows the application to look for the xml file
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
    //default bean name will be name of the method used here.
   //Now being defined in xml
    // @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }


    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }


    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
    //use @Value annotation to pull properties in from PropertySource
    @Bean
    FakeDataSource fakeDataSource(SFGConfig sfgConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(sfgConfig.getUserName());
        fakeDataSource.setPassword(sfgConfig.getPassword());
        fakeDataSource.setJdbcUrl(sfgConfig.getJdbcUrl());
        return fakeDataSource;
    }
    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository repository){
        return new GreetingServiceFactory(repository);
    }

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("en");
    }

//    @Bean
//    EnglishGreetingRepository englishGreetingRepository(){
//        return new EnglishGreetingRepositoryImpl();
//    }
//    @Profile("EN")
//    @Bean
//    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
//        return new I18nEnglishGreetingService(englishGreetingRepository);
//    }


    @Bean
    @Profile("es")
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("es");
    }

    @Bean
    @Profile("de")
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("de");
    }
}