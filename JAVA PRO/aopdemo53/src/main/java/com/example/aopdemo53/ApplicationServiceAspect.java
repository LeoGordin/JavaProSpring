package com.example.aopdemo53;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationServiceAspect {
    @Before(value = "execution(* com.example.aopdemo53.ApplicationController.getAllUsers(..))")
    public void beforeAdvice() {
        System.out.println("Before getAllUsers");
    }

    @After(value = "execution(* com.example.aopdemo53.ApplicationController.getAllUsers(..))")
    public void afterAdvice() {
        System.out.println("After getAllUsers");
    }

    @AfterReturning(value = "execution(* com.example.aopdemo53.ApplicationController.getAllUsers(..))")
    public void afterReturning() {
        System.out.println("After returning getAllUsers");
    }

    @Around(value = "execution(* com.example.aopdemo53.ApplicationController.getAllUsers(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("Around before getAllUsers");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Around exception: " + e.getMessage());
        }
        System.out.println("Around after getAllUsers");
    }

    @AfterReturning(
            value = "execution(* com.example.aopdemo53.MoneyService..*(..))",
            returning = "returnValue"
    )
    public void afterMoney(JoinPoint joinPoint, Object returnValue) {
        if (returnValue != null) // getValue
        {
            System.out.printf("Method: %s, class: %s, result: %s",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSourceLocation().getWithinType(),
                    returnValue
            );
        } else { // setValue
            System.out.printf("Method: %s, class: %s",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSourceLocation().getWithinType()
            );
        }
        Object[] args = joinPoint.getArgs();
        for (Object arg : args)
            System.out.print(" arg: " + arg);
        System.out.println();
    }
}
