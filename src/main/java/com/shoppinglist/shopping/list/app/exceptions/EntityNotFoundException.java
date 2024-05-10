package com.shoppinglist.shopping.list.app.exceptions;

public class EntityNotFoundException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Entity not found!";

    public EntityNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
