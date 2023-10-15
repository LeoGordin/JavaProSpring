package com.example.coffee53;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

// Repository - механизм взаимодействия с таблицей базы данных
// Класс проанотированный Entity должен иметь репозитори для сохранения его в базу данных
// Coffee - тип Entity
// String - тип ключа
// findByStartDateBetween -> findByPriceBetween
@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    Iterable<Coffee> findByPriceBetween(BigDecimal from, BigDecimal to);
    Iterable<Coffee> findByNameContaining(String text);


}

