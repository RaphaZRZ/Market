package com.market.market.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateProductDTO(
        @NotNull(message = "{price.NotNull}") @Positive(message = "{price.Positive}") BigDecimal price) {
}
