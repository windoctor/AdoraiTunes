package com.adoraitunes.exceptions;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
