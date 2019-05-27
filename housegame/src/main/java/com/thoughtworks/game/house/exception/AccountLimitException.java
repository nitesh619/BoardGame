package com.thoughtworks.game.house.exception;

public class AccountLimitException extends RuntimeException {
    private String message;

    public AccountLimitException(final String message) {
        super(message);
        this.message = message;
    }
}
