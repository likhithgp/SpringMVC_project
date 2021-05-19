package com.stackroute.usermanagementservice.exception;

/**
 * This is the exceptional class for user not found in database
 */
public class UserNotFoundException extends Exception {
    private String message;
   /**
     * No args constructor
     */

    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        this.message = message;
    }

}
