package com.example.school53;

public class Teacher {
    private Long id;
    private String name;
    private boolean working = true;

    public Teacher(Long id, String name, boolean working) {
        this.id = id;
        this.name = name;
        this.working = working;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
