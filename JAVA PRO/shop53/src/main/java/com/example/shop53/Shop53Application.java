package com.example.shop53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // только в этом случае задачи поставленные в расписание будут выполняться
public class Shop53Application {

	public static void main(String[] args) {
		SpringApplication.run(Shop53Application.class, args);
	}

}
