package com.example.ebelesson23.controller;

import com.example.ebelesson23.domain_layer.CommonUser;
import com.example.ebelesson23.domain_layer.User;
import com.example.ebelesson23.repository_layer.Repository;
import com.example.ebelesson23.service_layer.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Repository repository;

    @Autowired
    private PasswordService service;

    @GetMapping
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @GetMapping("/all/{name}")
    public List<User> getUsersByName(
            @PathVariable
            String name
    ) {
        return repository.getUsersByName(name);
    }

    @GetMapping("/{name}")
    public User getFirstUserByName(
            @PathVariable
            String name
    ) {
        return repository.getFirstUserByName(name);
    }

    @PostMapping
    public User addUser(
            @RequestBody
            CommonUser user
    ) {
        if (!service.checkPassword(user.getPassword())) {
            System.out.println("Password is too short!");
            return null;
        }

        repository.addUser(user.getName(), user.getPassword());
        return user;
    }
}