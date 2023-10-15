package com.example.ebelesson23.repository_layer;

import com.example.ebelesson23.domain_layer.Database;
import com.example.ebelesson23.domain_layer.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class UserRepository implements Repository {

    @Autowired
    Database dataBase;

    @Override
    public List<User> getAllUsers() {
        try {
            return dataBase.select("Select *");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersByName(String name) {
        try {
            return dataBase.select("Select * where name = " + name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getFirstUserByName(String name) {
        try {
            return dataBase.select("Select * where name = " + name).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(String name, String password) {
        try {
            dataBase.execute(String.format("Add user name = %s password = %s",
                    name, password));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}