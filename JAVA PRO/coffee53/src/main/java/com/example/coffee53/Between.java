package com.example.coffee53;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BetweenValidator.class)
@Documented
public @interface Between {
    String message() default "{Between.invalid}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

    double from();
    double to();
}
