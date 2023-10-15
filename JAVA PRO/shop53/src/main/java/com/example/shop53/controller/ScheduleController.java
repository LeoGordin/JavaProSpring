package com.example.shop53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ScheduleController {

    @Autowired
    private TaskScheduler taskScheduler; // компонент Spring
    // через который можно создавать динамические расписания


    // http://localhost:8080/schedule/max
    @GetMapping("/schedule/{name}")
    public String schedule(
            @PathVariable String name
    ) {
        taskScheduler.schedule(
                // поправьте runnable чтобы он выводил передаваемое имя
                // до 19:48
                () -> System.out.println("Hello " + name + ", time is: " + System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + 5_000)
        );
        return "success";
    }
}
