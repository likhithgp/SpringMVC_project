/*package com.stackroute.usermanagementservice.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.usermanagementservice.model.User;
import com.stackroute.usermanagementservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;*/

/*@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private UserRepository repo;
    @InjectMocks
    private UserService service;

    private PasswordEncoder bcryptEncoder;
    @Test
    public void loadByName()
    {
        User user=new User();
        user.setName("maria");
        user.setMobileNo(789012341);
        user.setPassword("password1");
        user.setUsername("maria124");
        when(repo.findByUsername("maria124")).thenReturn(user);
        service.loadUserByUsername("maria124");
        verify(repo,times(1)).findByUsername("maria124");
    }

}*/
