package com.stackroute.controller;

import java.util.List;
import java.util.Map;

import com.stackroute.finge.FingeDataFromAnotherMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.model.UserFavourite;
import com.stackroute.repository.UserFavoriteRepository;
import com.stackroute.service.UserFavouriteService;

/*Add RestController annotation 
 * it is to made it as rest application
 * Add RequestMapping Annotation(optional)
 * This to match the URL
 */
@RestController
@CrossOrigin(value="*")
@RequestMapping("api/v1")
public class UserFavouriteStockController {

	/*
	 * Define an Variable that perform
	 */

	private UserFavouriteService userFavouriteService;
	private FingeDataFromAnotherMicroService fingeDataFromAnotherMicroService;
	/*
	 * Add autowired annotation this to inject dependency
	 */

	@Autowired
	public UserFavouriteStockController(UserFavouriteService userFavouriteService,FingeDataFromAnotherMicroService fingeDataFromAnotherMicroService) {
		super();
		this.userFavouriteService = userFavouriteService;
		this.fingeDataFromAnotherMicroService=fingeDataFromAnotherMicroService;
	}

	@GetMapping("/favouritestocks")
	public ResponseEntity<List<UserFavourite>> getAllStockDetails() {
		return new ResponseEntity<List<UserFavourite>>(
				(List<UserFavourite>) userFavouriteService.getAllFavouriteStockList(), HttpStatus.OK);
	}

	/*
	 * Method to save UserFavouriteSTock in the db.
	 */

	@PostMapping("/favouritestock")
	public ResponseEntity<?> addTheStockToFavourite(@RequestParam String userName1, @RequestParam String companyName1,
			@RequestParam String price1) {

		double price = Double.parseDouble(price1);

		return new ResponseEntity<>(userFavouriteService.createFavouritStock(userName1, companyName1, price),
				HttpStatus.CREATED);

	}

	/*
	 * Method to GetAllThe List of userFavourite Stock in the db.
	 */

	@DeleteMapping("/favouritestock/{userName}")
	public ResponseEntity<?> getBlogAfterDeleting(@PathVariable String userName, @RequestParam String companyName) {

		return new ResponseEntity<>(userFavouriteService.deleteFavouriteStock(userName, companyName), HttpStatus.OK);
	}

	/*
	 * Method to get All favourite Stocks of a particular user
	 */

	@GetMapping("/favouritestock")
	public ResponseEntity<?> getFavouriteStocksofParticularUser(@RequestParam String userName)
	{
		return new ResponseEntity<>(userFavouriteService.getFavouriteStockListBasedOnUserName(userName), HttpStatus.OK);
	}

}
