package com.example.shop53.controller;

import com.example.shop53.entity.Card;
import com.example.shop53.entity.Product;
import com.example.shop53.repo.CardRepository;
import com.example.shop53.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ProductRepository productRepository;

    // GET http://localhost:8080/cards
    // GET /cards - список всех карт
    @GetMapping("/cards")
    public ResponseEntity<Iterable<Card>> getAllCards()
    {
        return ResponseEntity.ok(cardRepository.findAll());
    }


    // GET http://localhost:8080/products/3/cards
    // GET /products/{productId}/cards - все карты для продукта
    @GetMapping("/products/{productId}/cards")
    public ResponseEntity<Iterable<Card>> getAllCardsByProductId(
            @PathVariable Long productId
    )
    {
        if(!productRepository.existsById(productId))
            throw new IllegalArgumentException("Product with id:"+productId + " not found");

        return ResponseEntity.ok(cardRepository.findCardsByProductsId(productId));
    }


    // GET http://localhost:8080/cards/1
    // GET /cards/{id} - конкретная карта
    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCardById(
            @PathVariable Long id
    )
    {
        Card card = cardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Card with id:"+id + " not found")
        );
        return ResponseEntity.ok(card);
    }

    // GET http://localhost:8080/cards/1/products
    // GET /cards/{cardId}/products - все продукты для карты
    @GetMapping("/cards/{cardId}/products")
    public ResponseEntity<Iterable<Product>> getAllProductsByCardId(
            @PathVariable Long cardId
    )
    {
        if(!cardRepository.existsById(cardId))
            throw new IllegalArgumentException("Card with id:"+cardId + " not found");
        return ResponseEntity.ok(
                productRepository.findProductsByCardsId(cardId)
        );
    }


    // POST /products/{productId}/cards - создание карты для продукта
    @PostMapping("/products/{productId}/cards")
    public ResponseEntity<Card> addCard(
            @PathVariable Long productId,
            @RequestBody Card cardRequest
    )
    {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("Product with id:" + productId + " not found")
        );
        Long cardId = cardRequest.getId();
        if(cardId != null && cardId != 0L)
        {
            // когда карта и продукт существуют в базе данных
            Card _card = cardRepository.findById(cardId).orElseThrow(
                    () -> new IllegalArgumentException("Card with id:" + cardId + " not found")
            );
            product.addCard(_card);
            productRepository.save(product);
            return ResponseEntity.ok(_card);
        }
        product.addCard(cardRequest);
        return ResponseEntity.ok(cardRepository.save(cardRequest));
    }

    // PUT /card/{id} - изменение карты по идентификатору
    @PutMapping("/card/{id}")
    public ResponseEntity<Card> updateCard(
            @PathVariable Long id,
            @RequestBody Card cardRequest
    )
    {
        // найти карту по id
        //      если ее нет - выбросить исключение
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Card with id: " + id + " not found"));
        // если есть, поменять в ней имя
        card.setName(cardRequest.getName());
        // сохранить в репозитори измененную карту и вернуть ее измененную
        return ResponseEntity.ok(cardRepository.save(card));
    }




    // DELETE /card/{id} - удаление карты по идентификатору
    @DeleteMapping("/card/{id}")
    public ResponseEntity<HttpStatus> deleteCardById(
            @PathVariable Long id
    )
    {

        List<Product> products = new ArrayList<>();
        productRepository.findProductsByCardsId(id).forEach(products::add);

        products.forEach(
                p -> p.removeCard(id)
        );
        productRepository.saveAll(products);

        cardRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



    // DELETE /products/{productId}/cards/{cardId} - удаление продукта из карты
    @DeleteMapping("/products/{productId}/cards/{cardId}")
    public ResponseEntity<HttpStatus> deleteCardFromProduct(
            @PathVariable Long productId,
            @PathVariable Long cardId
    )
    {
        // найти продукт по идентификатору
        //      выбросить исключение если его нет
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with id: " + productId + " not found"));
        // удалить карту из продукта
        product.removeCard(cardId);
        // сохранить продукт
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
