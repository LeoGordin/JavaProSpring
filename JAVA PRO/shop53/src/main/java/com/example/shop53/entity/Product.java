package com.example.shop53.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
 @Setter
 @Getter
 @NoArgsConstructor
public class Product {
    @Id
    // выбираем стратегию автогенерации ключа
    // autoincrement
    // IDENTITY - в таблице бд ключ будет создан автоувеличивающейся колонкой
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PRODUCT_NAME", length = 50, nullable = false, unique = false)
    private String name;

    @Column(name = "PRODUCT_PRICE", columnDefinition = "Decimal(10,2) default '0.0'", nullable = false)
    private BigDecimal price;

    @Column(name = "PRODUCT_IS_ACTIVE", columnDefinition = "Boolean default 'true'", nullable = false)
    private boolean isActive;

    public Product(String name, BigDecimal price, boolean isActive) {
        this.name = name;
        this.price = price;
        this.isActive = isActive;
    }

    @OneToMany(
            mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true // если удаляем продукт, удалять все связанные с ним коменты
    )
    private Set<Comment> comments;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "product_card",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<Card> cards = new HashSet<>();

    public void addCard(Card card)
    {
        cards.add(card);
        card.getProducts().add(this);
    }

    public void removeCard(long cardId)
    {
        Card card = cards.stream().filter(c -> c.getId() == cardId).findFirst().orElse(null);
        if(card != null)
        {
            cards.remove(card);
            card.getProducts().remove(this);
        }
    }

}
