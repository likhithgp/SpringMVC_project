package com.stackroute.searchservice.service;


import com.stackroute.searchservice.exceptionHandling.CompanyNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service


public class SearchServiceImpl  implements SearchService{
	@Autowired
	private ResourceLoader resourceLoader;

    
	// for generating symbol for company where it is created in search service class and implemented in this class
	//in  try block it will store the generated symbols along with company names//
	//  for generating symbol it uses symbollist.json file//
	
	
	@Override
	public String getSymbols(String companyName) throws CompanyNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject dataObj = new JSONObject();
		Object symbol = new Object();
		String getSymbol = "";
		try {
			Resource resource = resourceLoader.getResource("classpath:SymbolList.json");
			JSONObject obj = (JSONObject) jsonParser.parse(new BufferedReader(new InputStreamReader(resource.getInputStream())));
			JSONArray jsonArray = (JSONArray) obj.get("companies");
			for (int i = 0; i < jsonArray.size(); i++) {
				dataObj = (JSONObject) jsonArray.get(i);
				if (dataObj.get("companyName").equals(companyName)) {
					symbol = dataObj.get("symbol");
					getSymbol = symbol.toString();

				}

			}
			if (getSymbol.isEmpty()) {
				throw new CompanyNotFoundException();
			}
          
			//this catch block will handle exceptions thrown by an external api//
			
		} catch (IOException e) {

			//System.out.println(e.getMessage());
		} catch (ParseException e) {
			//System.out.println(e.getMessage());
		}

		return getSymbol;
	}

}


