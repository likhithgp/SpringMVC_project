package com.stackroute.usermanagementservice.service;

import com.stackroute.usermanagementservice.model.UserDB;
import com.stackroute.usermanagementservice.model.User;
import com.stackroute.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * This class defines methods to load the user details and to persist the user details by using register end points
 */
@Service
public class UserService implements UserDetailsService {
   /**add autowired annotation
     *To inject dependency on run time
     */
    @Autowired
    private UserRepository userDao;
   /**add autowired annotation
     *To inject dependency on run time
     */

    @Autowired
    private PasswordEncoder bcryptEncoder;
   /**
     * This method loads user by username and throws username not found exception if the username and password
     * entered are invalid or the user is not registered yet
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
   /**
     * This method add the user details to the database
     */

    public User save(UserDB user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setMobileNo(user.getMobileNo());
        return userDao.save(newUser);
    }
}
