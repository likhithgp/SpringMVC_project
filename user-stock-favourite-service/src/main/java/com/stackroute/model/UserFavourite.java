package com.stackroute.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Document Annotation to store the Entity in mongoDB
 * MongoDb is non-relational database uses to store data in this microservice
 */

@Document(collection = "UserFavourite")
/*@Data annotation to add getters and setters
 *@NoargsConstructor to add the no parameterized constructor
 * @AllArgsconstructor to add the parametrized constructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavourite {

    @Id
    private String userName;
    private List<Map> favouriteStockCompany = new ArrayList<Map>();
    private LocalDateTime createdAt;

}
