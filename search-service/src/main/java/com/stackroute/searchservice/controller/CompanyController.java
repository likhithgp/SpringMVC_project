package com.stackroute.searchservice.controller;
import com.stackroute.searchservice.model.Company;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(value = "*")
public class CompanyController {

	
	// in this method  we sent the array which is the collection of symbol and company names //to the post man with help of annotations to get the required attributes //
	
    RestTemplate restTemplate=new RestTemplate();
    @GetMapping("/companies")
    public List<Company> getInfo(){
        String url="https://financialmodelingprep.com/api/v3/stock-screener?&sector=Technology&limit=32&apikey=07348517f82dbf1d74e766a75cc73b08";
        Company[] objects=restTemplate.getForObject(url, Company[].class);
        return Arrays.asList(objects);
    }
}


	



	