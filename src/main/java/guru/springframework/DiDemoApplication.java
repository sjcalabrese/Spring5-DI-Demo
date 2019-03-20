package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.controller.ConstructorInjectedController;
import guru.springframework.controller.MyController;
import guru.springframework.controller.PropertyInjectedController;
import guru.springframework.controller.SetterInjectedController;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		
		
		MyController controller = (MyController) ctx.getBean("myController");
		
		controller.hello();
		
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());		
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());	
	}
	

}
