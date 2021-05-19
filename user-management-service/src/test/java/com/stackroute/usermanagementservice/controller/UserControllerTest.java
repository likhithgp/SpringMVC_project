/*package com.stackroute.usermanagementservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.stackroute.usermanagementservice.model.User;
import com.stackroute.usermanagementservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;*/


/*@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserService service;
    @InjectMocks
    private AuthenticationController controller;
    private User userdto;
    @BeforeEach
    public void setUp(){
        userdto=new User();
        userdto.setName("john");
        userdto.setMobileNo(1234678);
        userdto.setPassword("password");
        userdto.setUsername("john12");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void addUser() throws Exception
    {
        when(service.save(any())).thenReturn(userdto);
        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userdto)))
                .andExpect(status().isOk());
        verify(service,times(1)).save(any());
    }
    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
*/