package com.market.market.models;

import com.market.market.dtos.ProductDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

/**
 * Represents a product in the market.
 * A product has a name, brand, price, and quantity.
 * It is mapped to the "products" table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "products")
@Table(name = "products")
public class Product {
    /**
     * Unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Name of the product. Must be between 3 and 60 characters.
     */
    @NotBlank(message = "{name.NotBlank}")
    @Size(min = 3, max = 60, message = "{name.Size}")
    @Column(name = "name")
    private String name;

    /**
     * Brand of the product. Must be between 3 and 60 characters.
     */
    @NotBlank(message = "{brand.NotBlank}")
    @Size(min = 3, max = 60, message = "{brand.Size}")
    @Column(name = "brand")
    private String brand;

    /**
     * Price of the product. Must be a positive value.
     */
    @NotNull(message = "{price.NotNull}")
    @Positive(message = "{price.Positive}")
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Quantity of the product in stock. Must be greater than or equal to zero.
     */
    @NotNull(message = "{quantity.NotNull}")
    @PositiveOrZero(message = "{quantity.PositiveOrZero}")
    @Column(name = "quantity")
    private Integer quantity;

    /**
     * Constructor that creates a `Product` object from a `ProductDTO`.
     *
     * @param productDTO the DTO containing the product data to initialize the product.
     */
    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.brand = productDTO.brand();
        this.price = productDTO.price();
        this.quantity = productDTO.quantity();
    }
}