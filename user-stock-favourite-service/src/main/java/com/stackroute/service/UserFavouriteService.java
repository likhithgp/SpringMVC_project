package com.stackroute.service;

import java.util.List;
import java.util.Map;

import com.stackroute.model.UserFavourite;

public interface UserFavouriteService {

	/*
	 * this method is to create new favourite to mongoDB using UserFavourite
	 * Repository
	 */

	public UserFavourite createFavouritStock(String userName,String companyName,double price);

	/*
	 * this method is to delete favourite from mongoDB using UserFavourite
	 * Repository
	 */

	public Map deleteFavouriteStock(String userName, String companyName);

	/*
	 * this method is to get all the favourite list from mongoDB using UserFavourite
	 * Repository
	 */

	public List<UserFavourite> getAllFavouriteStockList();

	/*
	 * this method is to get Favourite of a particular user
	 */
	public List<Map> getFavouriteStockListBasedOnUserName(String userName);
}
