package com.example.ebelesson23.domain_layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleDataBase implements Database {

    List<User> users = new ArrayList<>();

    public SimpleDataBase() {
        users.add(new CommonUser("Vanya", "qwerty"));
        users.add(new CommonUser("Petya", "asdfgh"));
        users.add(new CommonUser("Petya", "poiuyt"));
        users.add(new CommonUser("Sidor", "zxcvbn"));
    }

    @Override
    public void execute(String query) throws SQLException {
        // Add user name = Vasya password = qwerty
        if (!query.startsWith("Add")) {
            throw new SQLException("Неверный запрос!");
        }

        String[] parts = query.split(" ");
        users.add(new CommonUser(parts[4], parts[7]));
    }

    @Override
    public List<User> select(String query) throws SQLException {
        // Select * where name = Vasya
        if (!query.startsWith("Select")) {
            throw new SQLException("Неверный запрос!");
        }

        String[] parts = query.split(" ");
        if (parts.length == 2) {
            return users;
        } else {
            String name = parts[5];
            return users.stream().filter(x -> name.equals(x.getName())).collect(Collectors.toList());
        }
    }
}