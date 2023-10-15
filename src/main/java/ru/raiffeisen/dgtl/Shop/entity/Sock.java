package ru.raiffeisen.dgtl.Shop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "socks")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Sock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "cotton_part")
    @Min(value = 0, message = "Can't be less than 0")
    @Max(value = 100, message = "Can't be greater than 100")
    private Integer cottonPart;

    @Column(name = "quantity")
    private Integer quantity;

    public Sock(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }
}
