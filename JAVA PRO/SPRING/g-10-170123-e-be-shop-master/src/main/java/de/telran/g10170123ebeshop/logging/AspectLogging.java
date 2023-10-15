package de.telran.g10170123ebeshop.logging;

import de.telran.g10170123ebeshop.domain.entity.common.CommonProduct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

    private Logger LOGGER = LoggerFactory.getLogger(AspectLogging.class);

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.addProduct(..))()")
    public void addProduct() {
    }

    @Before("addProduct()")
    public void beforeAddingProduct(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        LOGGER.info("Adding product: {}", params[0]);
    }

    @After("addProduct()")
    public void afterAddingProduct(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        LOGGER.info("Added product granted ID: {}", ((CommonProduct) params[0]).getId());
    }

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.getById(..))")
    public void getCount() {
    }

    @AfterReturning("getCount()")
    public void afterReturningGetCount(JoinPoint joinPoint) {
        LOGGER.info("getCount successfully returned value");
    }

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.deleteById(..))")
    public void deleteById() {
    }

    @AfterThrowing("deleteById()")
    public void afterDeleteByIdThrowingExceptionIfIdIsIncorrect(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        LOGGER.error("deleteById threw Exception. Incorrect ID: {}", params[0]);
    }

    @Around("getCount()")
    public Object aroundGetProductCount(ProceedingJoinPoint joinPoint)  {
        LOGGER.info("getCount @Around was called");
        try {
            Object result = joinPoint.proceed();
            LOGGER.info("getCount @Around returned value: {}", result);
            LOGGER.info("Changing result and returning 777");
            return 777;
        } catch (Throwable throwable) {
            LOGGER.error("getCount threw Exception: {}", throwable.getMessage());
            throw new RuntimeException();
        }
    }
}
