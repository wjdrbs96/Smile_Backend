package com.smile.error.user;

/**
 * created by Gyunny 2021/10/30
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
