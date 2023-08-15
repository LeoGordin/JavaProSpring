package com.example.coffee53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@Bean - компонент который может быть предоставлен в качестве зависимости
@Service - компонент используемый для реализации бизнес-логики
@Controller - компонент получающий запросы из вне
@RestController - рест-ориентированный контроллер
@Repository - компонент осуществляющий взаимодействие с базами данных
@Entity - класс который может сохраняться через @Repository
 */


@SpringBootApplication
public class Coffee53Application {

	public static void main(String[] args) {
		SpringApplication.run(Coffee53Application.class, args);
	}

}
