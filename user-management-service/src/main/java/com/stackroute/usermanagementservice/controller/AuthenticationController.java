package com.stackroute.usermanagementservice.controller;

import com.stackroute.usermanagementservice.config.JwtTokenGenerator;
import com.stackroute.usermanagementservice.exception.UserAlreadyExistsException;
import com.stackroute.usermanagementservice.exception.UserNotFoundException;
import com.stackroute.usermanagementservice.filter.JwtRequest;
import com.stackroute.usermanagementservice.filter.JwtResponse;
import com.stackroute.usermanagementservice.model.UserDB;
import com.stackroute.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * In this class we are using two rest api endpoints ,/register to persist new user in database
 * and /authenticate to generate token for that user
 */
/**
 * The @RestController is a convenience annotation for creating RestFull controllers
 */
@RestController
/**
 * The @CrossOrigin annotation enables cross-origin resource sharing only for this specific method. By default,
 * its allows all origins, all headers, and the HTTP methods specified in the @RequestMapping annotation.
 */
@CrossOrigin
public class AuthenticationController {

   /**add autowired annotation
     *To inject dependency on run time
     */

    @Autowired
    private AuthenticationManager authenticationManager;

  /**add autowired annotation
     *To inject dependency on run time
     */

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

   /**add autowired annotation
     *To inject dependency on run time
     */
    @Autowired
    private UserService userDetailsService;
    @Value("${app.controller.exception.message1}")
    private String message1;

    @Value("${app.controller.exception.message2}")
    private String message2;

   /**
     * This method authenticates the credentials of the existing user from database
     */

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenGenerator.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
   /**
     * This method authenticates the credentials if the entered credentials are invalid it throws user
     * not found exception
     */

    private void authenticate(String username, String password) throws UserNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new UserNotFoundException(message1);
        } catch (BadCredentialsException e) {
            throw new UserNotFoundException(message2);
        }
    }
   /**
     * This method alows the user to register thier details in db
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDB user) throws UserAlreadyExistsException {

        return ResponseEntity.ok(userDetailsService.save(user));
    }
}
