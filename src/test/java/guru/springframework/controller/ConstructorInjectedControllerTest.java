//package guru.springframework.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import guru.springframework.services.GreetingServiceImpl;
//
//public class ConstructorInjectedControllerTest {
//	
//	private ConstructorInjectedController constructorInjectedController;
//	
//	@Before
//	public void setUp() throws Exception {
//		this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
//	}
//
//	@Test
//	public void test() throws Exception {
//		assertEquals(GreetingServiceImpl.HELLO_GURUS, constructorInjectedController.sayHello());
//	}
//
//}
