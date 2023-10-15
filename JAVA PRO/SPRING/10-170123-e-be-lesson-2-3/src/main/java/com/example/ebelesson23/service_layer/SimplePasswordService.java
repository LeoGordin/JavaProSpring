package com.example.ebelesson23.service_layer;

public class SimplePasswordService implements PasswordService{

    @Override
    public boolean checkPassword(String password) {
        return password.length() >= 5;
    }
}
