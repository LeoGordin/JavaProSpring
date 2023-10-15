package com.example.coffee53;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class BetweenValidator implements ConstraintValidator<Between, Double> {
    private BigDecimal from = BigDecimal.valueOf(0);
    private BigDecimal to = BigDecimal.valueOf(0);


    @Override
    public void initialize(Between c) {
        from = BigDecimal.valueOf(c.from());
        to = BigDecimal.valueOf(c.to());
    }

    @Override
    public boolean isValid(Double d, ConstraintValidatorContext c) {
        BigDecimal v = BigDecimal.valueOf(d);
        return v.compareTo(from) >= 0 && v.compareTo(to) <= 0;
    }
}