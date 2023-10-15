package com.example.shop53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// @Bean
// @Service
// @Controller
// @RestController
@Component
public class ShopScheduledTasks {

    // cron https://www.baeldung.com/cron-expressions
    // https://www.baeldung.com/spring-scheduled-tasks

    private static final Logger logger = LoggerFactory.getLogger(ShopScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // @Scheduled(fixedRate = 5_000)
    // @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    //                 s m    h    M d
    @Scheduled(cron = "0 3,10 9-17 * 1-5 *", zone = "Europe/Paris")
    public void reportApplicationHealth(){
        logger.info("reporting application health " + dateFormat.format(new Date()));
    }
}
