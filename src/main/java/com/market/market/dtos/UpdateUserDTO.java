package com.market.market.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserDTO(
        @NotBlank(message = "{username.NotBlank}") @Size(min = 3, max = 50, message = "{username.Size}") String username,
        @NotBlank(message = "{password.NotBlank}") @Size(min = 6, max = 60, message = "{password.Size}") String password) {
}
