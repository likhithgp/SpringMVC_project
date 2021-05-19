package com.stackroute.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.model.UserFavourite;
import com.stackroute.service.UserFavouriteServiceImplementation;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

/*@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class or test method.
 *add @Extendwith annotation
 */
@ExtendWith(MockitoExtension.class)
class UserFavouriteStockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserFavouriteServiceImplementation userFavouriteService;
    private UserFavourite userFavourite;
    private List<UserFavourite> listOfUserFavourite;

    @InjectMocks
    private UserFavouriteStockController userFavouriteStockController;

    @BeforeEach
    public void setUp() {
        UserFavourite userFavourite = new UserFavourite();
        userFavourite.setUserName("DG");
        userFavourite.setCreatedAt(LocalDateTime.now());
        List<Map> list = new ArrayList<Map>();
        Map items = new HashMap();
        items.put("companyName", "PayPal");
        items.put("price", 678.88);
        list.add(items);
        userFavourite.setFavouriteStockCompany(list);

        mockMvc = MockMvcBuilders.standaloneSetup(userFavouriteStockController).build();

    }

    @Test
    public void getStockUserFavouriteAllListShouldReturnTheListOfAllSavedUserFavouriteStocks() throws Exception {
        when(userFavouriteService.getAllFavouriteStockList()).thenReturn(listOfUserFavourite);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/favouritestocks")
                .contentType(MediaType.APPLICATION_JSON).content(asJasonString(userFavourite)));

        verify(userFavouriteService, times(1)).getAllFavouriteStockList();
    }

    public static String asJasonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}