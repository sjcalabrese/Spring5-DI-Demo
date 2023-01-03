package guru.springframework;

import guru.springframework.controllers.*;
import guru.springframework.datasource.FakeDataSource;
import guru.springframework.services.ProtoTypeBean;
import guru.springframework.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//use component scan to allow you to check other package for spring components
@ComponentScan(basePackages = {"guru.springframework", "com.springframework.pets"})
@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		//by default spring boot will do component scan in the parent package the this
		//is contained in. IE: guru.springframework package.
		//if anything is placed outside of this package it will be missed.

		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		//when creating a bean it will create the bean with the class name but with lower case first letter
		MyController controller = (MyController) ctx.getBean("myController");

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

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

		System.out.println("-----------Bean Scopes-------------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		ProtoTypeBean protoTypeBean1 = ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean1.getMyScope());
		ProtoTypeBean protoTypeBean2 = ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean2.getMyScope());


	}
}
