package com.example.aopdemo53;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/users")
    public String getAllUsers()
    {
        System.out.println("ApplicationController getAllUsers");
        return "users success";
    }

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/money/{value}")
    public String changeMoney(
            @PathVariable String value
    )
    {
        System.out.println(">>>>>");
        System.out.println("changeMoney value: " + value);
        System.out.println("changeMoney previous value: " + moneyService.getValue());
        moneyService.setValue(value);
        System.out.println("changeMoney current value: " + moneyService.getValue());
        System.out.println("<<<<<");
        return "money success";
    }
}
