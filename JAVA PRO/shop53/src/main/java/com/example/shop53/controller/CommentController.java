package com.example.shop53.controller;

import com.example.shop53.entity.Comment;
import com.example.shop53.entity.Product;
import com.example.shop53.repo.CommentRepository;
import com.example.shop53.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products/{productId}/comments")
    public ResponseEntity<Comment> createComment(
            @PathVariable Long productId,
            @RequestBody Comment comment
    )
    {
        // нужно загрузить продукт из репо
        // добавить к нему коммент
        // сохранить продукт
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null)
        {
            comment.setProduct(product);
            comment = commentRepository.save(comment);
        }
        return ResponseEntity.ok(comment);
    }


    // /comments/1
    @DeleteMapping("/comments/{id}") // - удаление комментария по идентификатору
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id)
    {
        commentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET http://localhost:8080/comments/2
    // GET /comments/{id} - комметарий по идентификатору
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentByCommentId(
            @PathVariable Long id
    )
    {
        // вернуть коммент по его идентификатору из репо
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null)
            return ResponseEntity.ok(comment);
        else
            throw new IllegalArgumentException("Comment with id="+id+" not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleConstraintViolationException(
            IllegalArgumentException ex
    ){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }


    // PUT /comments/{id} - изменение комментария по идентификатору
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long id,
            @RequestBody Comment comment
    )
    {
        // поправить аннотацию метода
        // найти коммент по id
        Comment commentToChange = commentRepository.findById(id).orElseThrow(
                // выбросить исключение если такого нет
                () -> new IllegalArgumentException("Comment with id:" + id + " not present")
        );
        // поменять в найденном content
        commentToChange.setContent(comment.getContent());
        // сохранить в базу и вернуть измененный комент
        return ResponseEntity.ok(commentRepository.save(commentToChange));
    }

    // GET http://localhost:8080/products/2/comments
    // GET /products/{productId}/comments - список всех коментов для продукта
    @GetMapping("/products/{productId}/comments")
    public ResponseEntity<Iterable<Comment>> getAllCommentsForProduct(
            @PathVariable Long productId
    )
    {
        return ResponseEntity.ok(
                commentRepository.findByProductId(productId)
        );
    }



    // DELETE http://localhost:8080/products/2/comments
    // DELETE /products/{productId}/comments - удаление всех комментариев для продукта
    @DeleteMapping("/products/{productId}/comments")
    public ResponseEntity<HttpStatus> deleteAllCommentsForProduct (
            @PathVariable Long productId
    )
    {
        // добавить аннотацию
        // проверьте если ли такой продукт
        // existsById
        if(!productRepository.existsById(productId))
            throw new IllegalArgumentException("Product with id:"+productId + " not found");
        // выбросить исключение если такого нет
        // написать в репозитори коментов функцию для удаления по productId
        // deleteByProductId
        // вызвать эту функцию
        commentRepository.deleteByProductId(productId);
        // вернуть HttpStatus.NO_CONTENT
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
