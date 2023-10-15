package com.example.ebelesson23.domain_layer;

public class CommonUser implements User {

    private String name;

    private String password;

    @Override
    public String toString() {
        return "CommonUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
