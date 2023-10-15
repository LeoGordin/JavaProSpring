package com.example.shop53.repo;

import com.example.shop53.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Iterable<Card> findCardsByProductsId(Long productId);
}
