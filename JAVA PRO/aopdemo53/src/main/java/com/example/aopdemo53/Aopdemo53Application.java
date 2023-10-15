package com.example.aopdemo53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true) // Enables AOP for application
public class Aopdemo53Application {

	public static void main(String[] args) {
		SpringApplication.run(Aopdemo53Application.class, args);
	}

}
