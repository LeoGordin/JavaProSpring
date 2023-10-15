package de.telran.g10170123ebeshop.domain.entity.common;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonProduct implements Product {

    private int id;

    private String name;

    private double price;

    Logger logger = LoggerFactory.getLogger(CommonProduct.class);

    public CommonProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        logger.info("getId was called");
        return id;
    }

    public void setId(int id) {
        logger.info("Id was set to {}", id);
        this.id = id;
    }

    @Override
    public String getName() {
        logger.info("getName was called");
        return name;
    }

    public void setName(String name) {
        logger.info("Name was set to {}", name);
        this.name = name;
    }

    @Override
    public double getPrice() {
        logger.info("getPrice was called");
        return price;
    }

    public void setPrice(double price) {
        logger.info("Price was set to {}", price);
        this.price = price;
    }
}