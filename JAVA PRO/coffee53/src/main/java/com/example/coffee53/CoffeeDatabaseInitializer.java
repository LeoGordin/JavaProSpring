package com.example.coffee53;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service // бизнес-логика приложения
public class CoffeeDatabaseInitializer implements CommandLineRunner {

    @Autowired // спринг создает экземпляр этого класса сам
    // и автоматически предоставляет здесь эту зависимость
    private CoffeeRepository coffeeRepository;

    // метод будет запущен при создании экземпляра класса Spring-ом
    @Override
    public void run(String... args) throws Exception {
        coffeeRepository.saveAll(
                Arrays.asList(
                        new Coffee("Cappuccino", BigDecimal.valueOf(2.3)),
                        new Coffee("Espresso", BigDecimal.valueOf(1.1)),
                        new Coffee("Latte", BigDecimal.valueOf(2.5)),
                        new Coffee("Americano", BigDecimal.valueOf(1.3)),
                        new Coffee("Ristretto", BigDecimal.valueOf(2.1)),
                        new Coffee("Flat White", BigDecimal.valueOf(1.8))
                )
        );
    }
}
