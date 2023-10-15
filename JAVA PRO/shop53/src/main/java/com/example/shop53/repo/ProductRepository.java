package com.example.shop53.repo;

import com.example.shop53.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findProductsByCardsId(Long cardId);

    // https://www.baeldung.com/spring-data-jpa-query



    // INSERT INTO products (PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE)
    // select p from Product p where p.price > :priceFrom and p.price < :priceTo
    @Query(
            value = "select * from products where PRODUCT_PRICE > :priceFrom and PRODUCT_PRICE < :priceTo",
            nativeQuery = true // на SQL конкретной базы данных
    )
    Iterable<Product> getProductsWithPriceBetween(BigDecimal priceFrom, BigDecimal priceTo);

    // напишите функцию которая вернет все продукты в названии которых есть подстрока
    // select * from products where product_name like '%pattern%'
    @Query(
            value = "select * from products where product_name like :pattern ",
            nativeQuery = true
    )
    Iterable<Product> getProductsWithNameLike(String pattern);

    // JPQL
    @Query(value = "select p from Product p where p.isActive = :status")
    Iterable<Product> getProductsWithStatus(boolean status);

    @Query(value = "select p from Product p order by p.id")
    Page<Product> getPage(Pageable pageable);
    // Pageable - параметры страницы для паджинации - начиная с какой позиции, сколько элементов

    @Query(value = "select p from Product p")
    Iterable<Product> getAll(Sort sort);

}
