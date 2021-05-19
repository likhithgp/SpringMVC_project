package com.stackroute.searchservice.service;

import com.stackroute.searchservice.exceptionHandling.CompanyNotFoundException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

 //In this interface we are method for generating symbols of a particular company//

public interface SearchService {
	
	String getSymbols(String companyName) throws CompanyNotFoundException, IOException, ParseException;
}
