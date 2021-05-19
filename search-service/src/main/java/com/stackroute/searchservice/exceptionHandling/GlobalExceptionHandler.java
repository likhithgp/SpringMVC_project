package com.stackroute.searchservice.exceptionHandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @Value(value = "$data.exception.message")
    private String message2;
  
    // if a particular company name is not found then it will send a message that  company is not found to client//
     
    
    @ExceptionHandler(value = CompanyNotFoundException.class)
    public ResponseEntity<String> CompanyNotFoundException(CompanyNotFoundException blogNotFoundException) {

        return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);

    }
}

