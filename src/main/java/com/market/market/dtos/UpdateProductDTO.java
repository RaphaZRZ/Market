package com.market.market.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateProductDTO(
        @NotNull(message = "{price.NotNull}") @Positive(message = "{price.Positive}") BigDecimal price,
        @NotNull(message = "{quantity.NotNull}") @PositiveOrZero(message = "{quantity.PositiveOrZero}") Integer quantity) {
}
