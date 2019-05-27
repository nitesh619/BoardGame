package com.thoughtworks.game.house.exception;

public class OutOfBoardException extends RuntimeException {

    private String message;

    public OutOfBoardException(final String message) {
        super(message);
        this.message = message;
    }
}
