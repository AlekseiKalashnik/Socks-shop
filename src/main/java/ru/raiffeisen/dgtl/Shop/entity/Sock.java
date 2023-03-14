package ru.raiffeisen.dgtl.Shop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sock")
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
    @Enumerated(EnumType.STRING)
    private SockColors color;

    @Column(name = "cottonPart")
    @Min(value = 0, message = "")
    @Max(value = 100, message = "")
    private int cottonPart;

    @Column(name = "quantity")
    @Min(value = 0, message = "")
    private int quantity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Sock(SockColors color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }
}
