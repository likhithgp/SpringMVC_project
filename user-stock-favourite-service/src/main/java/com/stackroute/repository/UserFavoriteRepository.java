package com.stackroute.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.model.UserFavourite;

/* Add Repository Annotation
 * enable annotated classes to be discovered and registered with application context.
 */

@Repository
public interface UserFavoriteRepository extends MongoRepository<UserFavourite, String> {

}
