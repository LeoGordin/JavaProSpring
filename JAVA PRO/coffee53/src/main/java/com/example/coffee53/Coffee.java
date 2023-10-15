package com.example.coffee53;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity // экземпляры класса могут прозрачно сохраняться и восстанавливаться из базы данных
// @Table(name = "teasandcoffees") // по-молчанию название таблицы это название класса
public class Coffee {
    @Id // по полю id в таблице базы данных будет создан вервичный ключ
    private String id;
    // @Column("cofee_name") // по-умолчанию названия колонок в таблице бд совпадают с названиями полей
    @NotBlank(message = "Coffee name should not be blank")
    @Pattern(regexp = "^.{5,}$", message = "minimal length of coffee name is 5 letters")
    private String name;
    @Min(value = 0, message = "minimal price should be greater than zero")
    @NotNull(message = "Price should not be null")
    @Between(from = 0.1, to=20.0, message = "Coffee price must be between 0.1 and 20.0")
    // @Max()
    private BigDecimal price;

    // в Entity классе должен быть безаргументный конструктор
    public Coffee() {
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coffee(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Coffee(String name, BigDecimal price)
    {
        this(UUID.randomUUID().toString(), name, price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
