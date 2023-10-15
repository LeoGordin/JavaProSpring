package de.telran.g10170123ebeshop.domain.entity.common;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Cart;
import de.telran.g10170123ebeshop.domain.entity.interfaces.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart {

    Logger logger = LoggerFactory.getLogger(CommonCart.class);

    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        logger.info("getProducts was called");
        return products;

    }

    @Override
    public void addProduct(Product product) {
        logger.info("{} was added to cart", product.getName());
        products.add(product);
    }

    @Override
    public double getTotalPrice() {
        logger.info("getTotalPrice was called");
        return products.stream().mapToDouble(Product::getPrice).reduce(Double::sum).orElse(0);
    }

    @Override
    public double getAveragePrice() {
        logger.info("getAveragePrice was called");
        if (products.isEmpty()) {
            return 0;
        }
        return getTotalPrice() / products.size();
    }

    @Override
    public void deleteProduct(int id) {
        logger.info("Product with id {} was deleted", id);
        products.removeIf(x -> x.getId() == id);
    }

    @Override
    public void clear() {
        logger.info("Cart was cleared");
        products.clear();
    }
}