package com.example.aopdemo53;

import org.springframework.stereotype.Service;

@Service // Business-logic
public class MoneyService {
    private String value = "100";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
