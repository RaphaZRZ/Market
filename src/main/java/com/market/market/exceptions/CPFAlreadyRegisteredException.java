package com.market.market.exceptions;

import lombok.Getter;

@Getter

public class CPFAlreadyRegisteredException extends RuntimeException {
    private final int statusCode;

    public CPFAlreadyRegisteredException() {
        super("CPF already registered.");
        this.statusCode = 409;
    }
}
