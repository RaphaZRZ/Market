package com.market.market.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {
    private final int statusCode;

    public ProductNotFoundException() {
        super("Product not found.");
        this.statusCode = 404;
    }
}
