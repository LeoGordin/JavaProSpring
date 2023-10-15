package com.example.shop53.repo;

import com.example.shop53.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    // id
    // content
    // product_id

    Iterable<Comment> findByProductId(Long productId);
    // так как потенциально эта функция может выполнить несколько запросов на удаление,
    // то нужно выполнять эти запросы в рамках транзакции
    @Transactional
    void deleteByProductId(Long productId);
}
