package de.telran.g10170123ebeshop.repository.common;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Product;
import de.telran.g10170123ebeshop.repository.interfaces.ProductRepository;

import java.util.List;

public class CommonProductRepository implements ProductRepository {


    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void add(String name, double price) {

    }

    @Override
    public void delete(int id) {

    }
}
