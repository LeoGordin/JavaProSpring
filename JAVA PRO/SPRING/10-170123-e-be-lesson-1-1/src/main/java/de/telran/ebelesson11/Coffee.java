package de.telran.ebelesson11;

import java.util.Objects;

public class Coffee {
    public Coffee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee coffee)) return false;
        return getId() == coffee.getId() && Objects.equals(getName(), coffee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


