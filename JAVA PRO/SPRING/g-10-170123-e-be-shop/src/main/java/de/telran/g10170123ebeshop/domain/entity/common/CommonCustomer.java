package de.telran.g10170123ebeshop.domain.entity.common;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Cart;
import de.telran.g10170123ebeshop.domain.entity.interfaces.Customer;

import java.util.Objects;

public class CommonCustomer implements Customer {

    private int id;

    private String name;

    private Cart cart;

    public CommonCustomer(int id, String name, Cart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonCustomer that)) return false;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getCart(), that.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCart());
    }

    @Override
    public String toString() {
        return "CommonCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cart=" + cart +
                '}';
    }
}
