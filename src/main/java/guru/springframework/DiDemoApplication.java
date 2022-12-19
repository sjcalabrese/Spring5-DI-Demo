package guru.springframework;

import guru.springframework.controllers.*;
import guru.springframework.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		//when creating a bean it will create the bean with the class name but with lower case first letter
		MyController controller = (MyController) ctx.getBean("myController");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("-----primary bean");
		System.out.println(controller.hello());
		System.out.println("-------property");
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println("----------getter");
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println("----------constructor");
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

	}
}
