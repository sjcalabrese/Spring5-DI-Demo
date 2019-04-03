//package guru.springframework.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import guru.springframework.services.GreetingServiceImpl;
//
//public class SetterInjectedControllerTest {
//	
//	private SetterInjectedController setterInjectedController;
//	
//	@Before
//	public void setUp() throws Exception {
//		
//		this.setterInjectedController = new SetterInjectedController();
//		this.setterInjectedController.getGreetingService(new GreetingServiceImpl());
//	}
//
//	@Test
//	public void test() {
//		assertEquals(GreetingServiceImpl.HELLO_GURUS, setterInjectedController.sayHello());
//	}
//
//}
