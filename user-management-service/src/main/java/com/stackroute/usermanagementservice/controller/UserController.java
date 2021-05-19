package com.stackroute.usermanagementservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Display /data rest end point to the user with the generated token
 */
/**
 * The @RestController is a convenience annotation for creating RestFull controllers
 */
@RestController
/**
 * The @CrossOrigin annotation enables cross-origin resource sharing only for this specific method. By default,
 * its allows all origins, all headers, and the HTTP methods specified in the @RequestMapping annotation.
 */
@CrossOrigin()
public class UserController {
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getEmployees() { return "Welcome!";
    }
}
