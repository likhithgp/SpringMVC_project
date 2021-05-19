package com.stackroute.usermanagementservice.config;

import com.stackroute.usermanagementservice.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Here we are using @Component
 * @Component - It is an object having graphical representation that
 * can be displayed on the screen and that can interact with the user
*/

/**
 * OncePerRequestFilter: OncePerRequestFilter guarantee single execution per request dispatch, on any servlet container
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    /**add autowired annotation
     *To inject dependency on run time
     */

    @Autowired
    private UserService userService;
    /**add autowired annotation
     *To inject dependency on run time
     */

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    /**
     *The doFilterInternal method of the filter is called each time a request/response pair is
     * passed through the chain due to a client request for the resource and the end of the chain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        /**
         * JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
          */
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenGenerator.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

        /**
         * Once we get the token validate it.
         */
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userService.loadUserByUsername(username);

            /**
             * if token is valid configure Spring Security to manually set authentication
              */
            if (jwtTokenGenerator.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                /** After setting the Authentication in the context, we specify
                 * that the current user is authenticated. So it passes the Spring Security Configurations successfully.
                 */
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
