package com.stackroute.usermanagementservice.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Here we are using @Component
 * @Component - It is an object having graphical representation that
 * can be displayed on the screen and that can interact with the user
 */

/**
 * The main function on AuthenticationEntryPoint is to allow the framework to send some sort of notifications
 * from application server to web client.
 */
@Component
public class JwtAuthentication implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}