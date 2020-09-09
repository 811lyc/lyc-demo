package com.lyc.aop01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Aop01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Aop01Application.class, args);
//		for(String s :run.getBeanDefinitionNames()){
//			System.out.println(s);
//		}
	}

}
