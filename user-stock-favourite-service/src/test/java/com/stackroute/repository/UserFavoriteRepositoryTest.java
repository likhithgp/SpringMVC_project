package com.stackroute.repository;

import com.stackroute.model.UserFavourite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.stackroute.repository.UserFavoriteRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


/*@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class or test method.
 *add @Extendwith annotation
 *@DataJpa to load the required code for testing
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserFavoriteRepositoryTest {

    /*add autowired annotation
     *To inject dependency on run time
     */
    @Autowired
    private UserFavoriteRepository userFavoriteRepository;

    /*
     *this to check the User Saved or Not
     */



    @Test
    public void toCheckTheUserIsSavedOrNot()
    {
        UserFavourite userFavourite=new UserFavourite();
        userFavourite.setUserName("DG");
        userFavourite.setCreatedAt(LocalDateTime.now());
        List<Map> list=new ArrayList<Map>();
        Map items=new HashMap();
        items.put("companyName","PayPal");
        items.put("price",678.88);
        list.add(items);
        userFavourite.setFavouriteStockCompany(list);

        userFavoriteRepository.save(userFavourite);

        List<UserFavourite> userFavouritelist=userFavoriteRepository.findAll();
        assertNotNull(userFavouritelist);
        assertEquals(userFavouritelist.get(0).getUserName(),userFavouritelist.get(0).getUserName());

    }


}
