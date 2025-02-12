package com.market.market.exceptions;

import lombok.Getter;

@Getter

public class EmailAlreadyRegisteredException extends RuntimeException {
    private final int statusCode;

    public EmailAlreadyRegisteredException() {
        super("Email already registered.");
        this.statusCode = 409;
    }
}
