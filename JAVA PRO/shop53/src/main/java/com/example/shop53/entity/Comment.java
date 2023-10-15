package com.example.shop53.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore // когда будет формироваться json комментария не включать туда продукт
    private Product product;

    public Comment(String content, Product product) {
        this.content = content;
        this.product = product;
    }
}
