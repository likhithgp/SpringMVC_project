package com.stackroute.usermanagementservice.exception;

/**
 * This is the exceptional class for user already exists in the database
 */
public class UserAlreadyExistsException extends Exception {
    private String message;
   /**
     * No args constructor
     */

    public UserAlreadyExistsException() {

    }

    public UserAlreadyExistsException(String message) {
        this.message = message;
    }
}

