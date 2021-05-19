package com.stackroute.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.stackroute.model.UserFavourite;
import com.stackroute.repository.UserFavoriteRepository;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

/*@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class or test method.
 *add @Extendwith annotation
 */

@ExtendWith(MockitoExtension.class)
public class UserFavouriteServiceTest {

    /*
     * Add @Mock annotation It create a mock object to perform test Add @InjectMocks
     * This tell where to inject the mock
     */
    @Mock
    private UserFavoriteRepository userFavoriteRepository;
    @InjectMocks
    private UserFavouriteServiceImplementation userFavouriteService;

    /*
     * @Test Annotation to set it as individual test case This the Function which
     * test the return object after save
     */
    @Test
    public void afterSavingTheFavouriteStockItShouldReturnWholeUserFavouriteStockObject() {
        UserFavourite userFavourite = new UserFavourite();
        userFavourite.setUserName("Ram");
        userFavourite.setCreatedAt(LocalDateTime.now());
        List<Map> list = new ArrayList<Map>();
        Map items = new HashMap();
        items.put("companyName", "Cisco");
        items.put("price", 578.88);
        list.add(items);
        userFavourite.setFavouriteStockCompany(list);

        when(userFavoriteRepository.save(any())).thenReturn(userFavourite);
        userFavouriteService.createFavouritStock("Ram", "Cisco", 578.56);
        verify(userFavoriteRepository, times(1)).save(any());

    }
}
