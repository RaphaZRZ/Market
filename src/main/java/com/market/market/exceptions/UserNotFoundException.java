package com.market.market.exceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final int statusCode;

    public UserNotFoundException() {
        super("User not found.");
        this.statusCode = 404;
    }
}
