package com.example.coffee53;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CoffeeController {
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeController()
    {
        coffees.addAll(List.of(
                new Coffee("Cappuccino"),
                new Coffee("Espresso"),
                new Coffee("Latte"),
                new Coffee("Americano"),
                new Coffee("Ristretto")
        ));
    }

    // http://localhost:8080/coffees
    //@RequestMapping(value = "/coffees", method = RequestMethod.GET)
    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    // http://localhost:8080/coffee/123
    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable("id") String id)
    {
        return coffees.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @DeleteMapping("/coffee/{id}")
    void delete(@PathVariable("id") String id)
    {
        coffees.removeIf(c -> c.getId().equals(id));
    }

    @PutMapping("/coffee")
    Coffee createCoffee(@RequestBody Coffee coffee)
    {
        // @RequestBody если ждем с клиента json
        coffees.add(coffee);
        return coffee;
    }

    @PostMapping("/coffee/{id}")
    Coffee changeCoffee(@PathVariable("id") String id,
                        @RequestBody Coffee coffee)
    {

        for(int i = 0; i < coffees.size(); i++)
        {
            if(coffees.get(i).getId().equals(id)) {
                coffees.set(i, coffee);
                return coffee;
            }
        }
        return null;
    }
}
