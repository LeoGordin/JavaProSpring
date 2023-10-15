package de.telran.g10170123ebeshop.domain.entity.common;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Cart;
import de.telran.g10170123ebeshop.domain.entity.interfaces.Product;

import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart {

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product: products) {
            totalPrice += product.getPrice();
        }
        
        return totalPrice;
    }

    @Override
    public double getAveragePrice() {
        if (!products.isEmpty()) {
            return getTotalPrice() / products.size();
        } else return 0;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(int productId) {
        products.removeIf(p -> p.getId() == productId);
    }

    @Override
    public void clear() {
        products.clear();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
