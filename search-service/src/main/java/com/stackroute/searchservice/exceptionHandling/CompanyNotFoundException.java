package com.stackroute.searchservice.exceptionHandling;

//This particular class is for handling exceptions//


public class CompanyNotFoundException extends Exception {

    String message;

     // no args constructor//
    
    public CompanyNotFoundException() {
    }

       // parametrized constructor//
    
    public CompanyNotFoundException(String message) {
        super();
        this.message = message;
    }

}
