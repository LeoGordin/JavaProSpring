package com.example.coffee53;

import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class CoffeeController {
    private List<Coffee> coffees = new ArrayList<>();

    // используется для вывода диагностических сообщений в консоль
    private static final Logger log = LoggerFactory.getLogger(CoffeeController.class);


    // спринг автоматически проинстанциирует и вкючить сюда
    // запрошенную зависимость
    @Autowired
    private CoffeeRepository coffeeRepository;

    public CoffeeController() {
//        coffees.addAll(List.of(
//                new Coffee("Cappuccino"),
//                new Coffee("Espresso"),
//                new Coffee("Latte"),
//                new Coffee("Americano"),
//                new Coffee("Ristretto")
//        ));
    }

    // http://localhost:8080/coffees
    //@RequestMapping(value = "/coffees", method = RequestMethod.GET)
    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        //return coffees;
        return coffeeRepository.findAll();
    }

    // http://localhost:8080/coffee/123
    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable("id") String id) {
        // return coffees.stream().filter(c -> c.getId().equals(id)).findFirst();
        return coffeeRepository.findById(id);
    }

    @DeleteMapping("/coffee/{id}")
    void delete(@PathVariable("id") String id) {
        // trace debug info warning error
        log.info("DELETE coffee with id: " + id);
        // coffees.removeIf(c -> c.getId().equals(id));
        coffeeRepository.deleteById(id);
    }

    @PutMapping("/coffee")
    Coffee createCoffee(@RequestBody Coffee coffee) {
        log.info("PUT coffee " + coffee.getId());
        // @RequestBody если ждем с клиента json
        // coffees.add(coffee);
        // return coffee;
        return coffeeRepository.save(coffee);
    }

    @PostMapping("/coffee/{id}")
    Coffee changeCoffee(@PathVariable("id") String id,
                        @RequestBody Coffee coffee) {

//        for(int i = 0; i < coffees.size(); i++)
//        {
//            if(coffees.get(i).getId().equals(id)) {
//                coffees.set(i, coffee);
//                return coffee;
//            }
//        }
//        return null;
        return coffeeRepository.save(coffee);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintViolationException(
            ConstraintViolationException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(
                violation -> {
                    errors.put(
                            violation.getPropertyPath().toString(),
                            violation.getMessage()
                    );
                }
        );
        return errors;
    }

    // напишите метод
    // GET http://localhost:8080/between?from=1.2&to=3.4
    // верните в этом методе все кофе из выбранного диапазона цены
    // вызывав метод репозитори
    @GetMapping("/between")
    public Iterable<Coffee> between(
            @RequestParam(name = "from") BigDecimal from,
            @RequestParam(name = "to") BigDecimal to) {
        return coffeeRepository.findByPriceBetween(from, to);
    }

    // напишите метод
    // GET http://localhost:8080/find?text=ap
    // добавьте в репозитори метод который ищет по содержащейся в имени кофе
    // подстроке
    @GetMapping("/find")
    public Iterable<Coffee> find(@RequestParam String text){
        return coffeeRepository.findByNameContaining(text);
        // до 20:30
    }

}
