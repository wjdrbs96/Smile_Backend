package com.smile.error;

/**
 * created by Gyunny 2021/10/30
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
