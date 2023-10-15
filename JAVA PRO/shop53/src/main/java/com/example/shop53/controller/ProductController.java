package com.example.shop53.controller;

import com.example.shop53.entity.Product;
import com.example.shop53.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // GET http://localhost:8080/products/priceBetween?from=1&to=3
    @GetMapping("/products/priceBetween")
    public Iterable<Product> priceBetween(
            @RequestParam (defaultValue = "0.0") BigDecimal from,
            @RequestParam (defaultValue = "0.0") BigDecimal to
    )
    {
        return productRepository.getProductsWithPriceBetween(from, to);
    }

    // GET http://localhost:8080/products/nameLike?pattern=as
    @GetMapping("/products/nameLike")
    public Iterable<Product> priceBetween(
            @RequestParam (defaultValue = "") String pattern
    )
    {
        pattern = "%" + pattern + "%";
        return productRepository.getProductsWithNameLike(pattern);
    }

    // GET http://localhost:8080/products/byStatus?status=true
    @GetMapping("/products/byStatus")
    public Iterable<Product> getProductsByStatus(
            @RequestParam (defaultValue = "true") boolean status
    )
    {
        return productRepository.getProductsWithStatus(status);
    }

    // GET http://localhost:8080/products/page?page=0&size=5
    @GetMapping("/products/page")
    public Iterable<Product> getPage(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "5") int size
    )
    {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productRepository
                .getPage(pageable)
                .get()
                .collect(Collectors.toList());
    }

    // GET http://localhost:8080/products/sort?column=price&direction=DESC
    @GetMapping("/products/sort")
    public Iterable<Product> sort(
            @RequestParam (defaultValue = "id") String column,
            @RequestParam (defaultValue = "ASC") String direction
    )
    {
        Sort.Direction dir = direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return productRepository.getAll(Sort.by(dir, column));
    }


}
