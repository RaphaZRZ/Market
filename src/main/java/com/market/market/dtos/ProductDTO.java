package com.market.market.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank(message = "{name.NotBlank}") @Size(min = 3, max = 60, message = "{name.Size}") String name,
        @NotBlank(message = "{brand.NotBlank}") @Size(min = 3, max = 60, message = "{brand.Size}") String brand,
        @NotNull(message = "{price.NotNull}") @Positive(message = "{price.Positive}") BigDecimal price,
        @NotNull(message = "{quantity.NotNull}") @PositiveOrZero(message = "{quantity.PositiveOrZero}") Integer quantity) {
}
