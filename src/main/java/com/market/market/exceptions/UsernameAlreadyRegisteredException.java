package com.market.market.exceptions;

import lombok.Getter;

@Getter

public class UsernameAlreadyRegisteredException extends RuntimeException {
    private final int statusCode;

    public UsernameAlreadyRegisteredException() {
        super("Username already registered.");
        this.statusCode = 409;
    }
}
