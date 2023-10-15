package com.example.ebelesson23.repository_layer;

import com.example.ebelesson23.domain_layer.User;

import java.util.List;

public interface Repository {

    List<User> getAllUsers();

    List<User> getUsersByName(String name);

    User getFirstUserByName(String name);

    void addUser(String name, String password);
}
