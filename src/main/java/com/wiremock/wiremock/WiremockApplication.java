package com.wiremock.wiremock;

import com.wiremock.wiremock.bean.BeanTest;
import com.wiremock.wiremock.bean.Singletonbean;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.Signature;

@SpringBootApplication
public class WiremockApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiremockApplication.class, args);
		//ApplicationContext contextt=new ApplicationContext(BeanTest.class);
		ConfigurableApplicationContext context = SpringApplication.run(WiremockApplication.class,args);

        BeanTest beanTest1= context.getBean(BeanTest.class);
		BeanTest beanTest2= context.getBean(BeanTest.class);
		BeanTest beanTest3= context.getBean(BeanTest.class);

		Singletonbean singletonbean= context.getBean(Singletonbean.class);
		Singletonbean singletonbean2= context.getBean(Singletonbean.class);
		System.out.println("bean testing "+singletonbean.prototypeBean().hashCode()+" :  "+singletonbean2.prototypeBean().hashCode());



	}

}
