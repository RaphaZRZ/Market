package com.market.market.dtos;

import com.market.market.models.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank(message = "{firstName.NotBlank}") @Size(min = 3, max = 20, message = "{firstName.Size}") String firstName,
        @NotBlank(message = "{lastName.NotBlank}") @Size(min = 3, max = 20, message = "{lastName.Size}") String lastName,
        @NotBlank(message = "{username.NotBlank}") @Size(min = 3, max = 50, message = "{username.Size}") String username,
        @NotBlank(message = "{CPF.NotBlank}") @Size(min = 11, max = 11, message = "{CPF.Size}") String CPF,
        @NotBlank(message = "{email.NotBlank}") @Size(min = 6, max = 320, message = "{email.Size}") @Email(message = "{email.Invalid}") String email,
        @NotBlank(message = "{password.NotBlank}") @Size(min = 6, max = 60, message = "{password.Size}") String password,
        @NotNull(message = "{userType.NotNull}") UserType userType) {
}
