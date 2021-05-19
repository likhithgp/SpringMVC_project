package com.stackroute.searchservice.controller;

import com.stackroute.searchservice.exceptionHandling.CompanyNotFoundException;
import com.stackroute.searchservice.model.Stock;
import com.stackroute.searchservice.service.SearchService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;



@RestController
@RequestMapping("/api/v1") 
@CrossOrigin(value = "*")
public class StockController {

    @Autowired
    private SearchService searchService;
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public StockController(com.stackroute.searchservice.service.SearchService searchService, RestTemplate restTemplate) {
        this.searchService = searchService;
        this.restTemplate = restTemplate;
    }

//sending values to postman by concanating symbol with external api where we find company name  //
    // if company name is not found it will throw exception then catch block will handle exception//
    @GetMapping("/details")
    public ResponseEntity<?> getInfo(@RequestParam(value = "name") String name) throws IOException, CompanyNotFoundException, ParseException {
        try {
            String sym = this.searchService.getSymbols(name);
            String url = "https://financialmodelingprep.com/api/v3/historical-price-full/" + sym + "?timeseries=7&apikey=07348517f82dbf1d74e766a75cc73b08";
            Stock objects = restTemplate.getForObject(url, Stock.class);
            return new ResponseEntity<>(Arrays.asList(objects), HttpStatus.OK);

        } catch (CompanyNotFoundException e) {
            return new ResponseEntity<>("Company NOt Found", HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/detail")
    public Object getInfoinCard(@RequestParam(value = "name") String name) throws IOException, CompanyNotFoundException, ParseException {
        String sym = this.searchService.getSymbols(name);
        String url = "https://financialmodelingprep.com/api/v3/historical-price-full/" + sym + "?timeseries=8&apikey=07348517f82dbf1d74e766a75cc73b08";
        Object objects = restTemplate.getForObject(url, Stock.class);
        return Arrays.asList(objects);
    }


}
