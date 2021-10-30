package com.smile.error.post;

/**
 * created by Gyunny 2021/10/30
 */
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message) {
        super(message);
    }

}
