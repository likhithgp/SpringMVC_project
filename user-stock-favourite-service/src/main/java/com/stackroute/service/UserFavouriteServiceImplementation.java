package com.stackroute.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.UserFavourite;
import com.stackroute.repository.UserFavoriteRepository;

/* Add Service annotation 
 *this is used with classes that provide some business functionalities.
 */
@Service
public class UserFavouriteServiceImplementation implements UserFavouriteService {

	/*
	 * AutoWired annotation to inject the dependency UserFavouriterepository will
	 * use the Mongodb-Repository to perform the database operations.
	 */

	private UserFavoriteRepository userFavoriteRepository;

	@Autowired
	public UserFavouriteServiceImplementation(UserFavoriteRepository userFavoriteRepository) {
		this.userFavoriteRepository = userFavoriteRepository;
	}
	/*
	 * The method is defined in interface(UserFavouriteService)
	 * 
	 */

	@Override
	public UserFavourite createFavouritStock(String userName, String companyName, double price) {

		List<UserFavourite> list = getAllFavouriteStockList();

		if (list != null) {

			for (UserFavourite userFavourite12 : list) {
				if (userName.equals(userFavourite12.getUserName())) {
					List<Map> favStockCompyPrice = userFavourite12.getFavouriteStockCompany();

					Map items = new HashMap();
					items.put("companyName", companyName);
					items.put("price", price);

					favStockCompyPrice.add(items);

					userFavourite12.setFavouriteStockCompany(favStockCompyPrice);

					userFavoriteRepository.save(userFavourite12);

					return userFavourite12;
				}

			}
		}
		UserFavourite userAdd = new UserFavourite();
		userAdd.setCreatedAt(LocalDateTime.now());
		userAdd.setUserName(userName);

		Map items = new HashMap();
		items.put("companyName", companyName);
		items.put("price", price);
		List<Map> favStockCompyPrice = new ArrayList<Map>();

		favStockCompyPrice.add(items);
		userAdd.setFavouriteStockCompany(favStockCompyPrice);

		userFavoriteRepository.save(userAdd);

		return userAdd;
	}

	/*
	 * The method is defined in interface(UserFavouriteService)
	 * 
	 */
	@Override
	public Map deleteFavouriteStock(String userName, String companyName) {
		// TODO Auto-generated method stub
		List<UserFavourite> list = getAllFavouriteStockList();
		if (list == null) {
			Map errorMessage=new HashMap();
			errorMessage.put("Message","Threr is nothing to delete");
			return  errorMessage;

		}
		for (UserFavourite userFavourite4 : list) {
			if (userName.equals(userFavourite4.getUserName())) {
				List<Map> items = userFavourite4.getFavouriteStockCompany();

				for (Map item : items) {
					if (item.get("companyName").equals(companyName)) {
						Map deletedItem=new HashMap();
						deletedItem.put("companyName",item.get("companyName"));
						deletedItem.put("price",item.get("price"));
						items.remove(item);
						userFavourite4.setFavouriteStockCompany(items);
						userFavoriteRepository.save(userFavourite4);
						return deletedItem;
					}
				}
			}

		}

		return (Map)new HashMap().put("ErrorMessage","NO company exist with that Name");

	}
	/*
	 * The method is defined in interface(UserFavouriteService)
	 * 
	 */

	@Override
	public List<UserFavourite> getAllFavouriteStockList() {
		// TODO Auto-generated method stub

		List<UserFavourite> userFavStockList = userFavoriteRepository.findAll();

		return userFavStockList;
	}

	/*
	 * The method is defined in interface(UserFavouriteService)
	 *
	 */
	@Override
	public List<Map> getFavouriteStockListBasedOnUserName(String userName) {
		// TODO Auto-generated method stub

		List<UserFavourite> list = userFavoriteRepository.findAll();
		for (UserFavourite userFavourite1 : list) {
			if (userName.equals(userFavourite1.getUserName())) {

				List<Map> favouriteStocks = userFavourite1.getFavouriteStockCompany();

				return favouriteStocks;

			}

		}

		return null;
	}

}
