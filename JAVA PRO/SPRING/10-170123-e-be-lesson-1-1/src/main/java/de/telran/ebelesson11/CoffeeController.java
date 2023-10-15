package de.telran.ebelesson11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    //http://www.example.com/coffee
    //http://127.0.0.1:8080/coffee
    //http://localhost:8080/coffee

    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeController() {
        coffeeList.add(new Coffee(1, "Latte"));
        coffeeList.add(new Coffee(2, "Americano"));
        coffeeList.add(new Coffee(3, "Cappuccino"));
        coffeeList.add(new Coffee(4, "Mocha"));
        coffeeList.add(new Coffee(5, "Cortado"));
    }

    @GetMapping
    public List<Coffee> getAll() {
        return coffeeList;
    }
}
