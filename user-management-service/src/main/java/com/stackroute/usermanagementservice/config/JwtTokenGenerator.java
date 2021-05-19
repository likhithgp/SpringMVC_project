package com.stackroute.usermanagementservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Here we are using @Component
 * @Component - It is an object having graphical representation that
 * can be displayed on the screen and that can interact with the user
 */

@Component
public class JwtTokenGenerator implements Serializable {
    /**
     * Here we are using serialVersionUID
     * The serialization at runtime associates with each serializable class a version number
     * called as serialVersionUID
     */

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 120000;

    @Value("${jwt.secret}")
    private String secret;
    /**
     * This method is used to get the username from the generated token
     */

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
   /**
     * This method is used to get the date the token was issued
     */


    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }
   /**
     * This method gives the expiration date of token
     */

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
   /**
     * This method gives the selected  the information of a user from the token
     */


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
   /**
     * This method gives all information of the user from the token
     */

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
   /**
     * This method gives the expiration date of token to the user before it gets expired
     */

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration(String token) {
        /**
         *  specify tokens, for that the expiration is ignored
         */
        return false;
    }
   /**
     * This is used method generate the token for the given userdetails
     */

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }
   /**
     * This method set the claims,subject,issued date of token,expiration date of token
     */

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512,  secret).compact();
    }
   /**
     * This method shows if the token be refreshed or not
     */


    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }
   /**
     * This method validates the token for the given username and password
     */

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
