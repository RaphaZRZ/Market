package com.market.market.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "products")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "{name.NotNull}")
    @Size(min = 3, max = 60, message = "{name.NotNull}")
    @Column(name = "name")
    private String name;

    @NotNull(message = "{brand.NotNull}")
    @Size(min = 3, max = 60, message = "{brand.NotNull}")
    @Column(name = "brand")
    private String brand;

    @NotNull(message = "{price.NotNull}")
    @Positive(message = "{price.Positive}")
    @Column(name = "price")
    private BigInteger price;

    @NotNull(message = "{quantity.NotNull}")
    @Column(name = "quantity")
    private Integer quantity;
}