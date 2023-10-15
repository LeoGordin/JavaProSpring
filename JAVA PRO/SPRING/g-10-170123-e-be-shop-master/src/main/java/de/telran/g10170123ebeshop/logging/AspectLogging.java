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

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.getTotalPrice(..))")
    public void getTotalPrice() {
    }

    @Around("getTotalPrice()")
    public Object aroundGetTotalPrice(ProceedingJoinPoint joinPoint)  {
        LOGGER.info("getTotalPrice @Around was called");
        try {
            Object result = joinPoint.proceed();
            LOGGER.info("getTotalPrice @Around returned value: {}", result);
            return result;
        } catch (Throwable throwable) {
            LOGGER.error("getTotalPrice threw Exception: {}", throwable.getMessage());
            throw new RuntimeException();
        }
    }

    @After("getTotalPrice()")
    public void afterGetTotalPrice(JoinPoint joinPoint) {
        LOGGER.info("getTotalPrice successfully returned total price");
    }

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.deleteByName(..))")
    public void deleteByName() {

    }

    @Around("deleteByName()")
    public Object aroundDeleteByName(ProceedingJoinPoint joinPoint)  {
        LOGGER.info("deleteByName @Around was called");
        try {
            Object result = joinPoint.proceed();
            LOGGER.info("deleteByName @Around deleted product: {}", result);
            return result;
        } catch (Throwable throwable) {
            LOGGER.error("deleteByName threw Exception: {}", throwable.getMessage());
            throw new RuntimeException();
        }
    }

    @After("deleteByName()")
    public void afterDeleteByName(JoinPoint joinPoint) {
        LOGGER.info("deleteByName successfully deleted product, ID: {}", ((CommonProduct) joinPoint.getArgs()[0]).getId());
    }

    @Pointcut("execution(* de.telran.g10170123ebeshop.service.*(..))")
    public void allMethods() {

    }

    @Around("allMethods()")
    public Object aroundAllMethods(ProceedingJoinPoint joinPoint)  {
        LOGGER.info("Class {} method {} @Around was called with parameters: {}",joinPoint.getClass(), joinPoint.getSignature().getName(), joinPoint.getArgs());
        try {
            Object result = joinPoint.proceed();
            LOGGER.info("Class {} method {} @Around returned value: {}", joinPoint.getClass(),joinPoint.getSignature().getName(), result);
            return result;
        } catch (Throwable throwable) {
            LOGGER.error("Class {} method {} threw Exception: {}",joinPoint.getClass(), joinPoint.getSignature().getName(), throwable.getMessage());
            throw new RuntimeException();
        }
    }

    @After("allMethods()")
    public void afterAllMethods(JoinPoint joinPoint) {
        LOGGER.info("Class {} method {} successfully worked", joinPoint.getClass(), joinPoint.getSignature().getName());
    }

    @AfterReturning("allMethods()")
    public void afterReturningAllMethods(JoinPoint joinPoint) {
        LOGGER.info("Class {} method {} successfully returned value {}", joinPoint.getClass(), joinPoint.getSignature().getName(), joinPoint.getArgs()[0]);
    }

    @AfterThrowing("allMethods()")
    public void afterThrowingAllMethods(JoinPoint joinPoint) {
        LOGGER.error("Class {} method {} threw Exception {}", joinPoint.getClass(), joinPoint.getSignature().getName(), joinPoint.getArgs()[0]);
    }
}
