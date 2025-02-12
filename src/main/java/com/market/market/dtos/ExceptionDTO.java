package com.market.market.dtos;

import java.time.LocalDateTime;

public record ExceptionDTO(LocalDateTime timestamp, String message, int statusCode) {
}
