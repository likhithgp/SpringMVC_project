package com.stackroute.searchservice.model;


// This particular is class  written for defining attributes that is required from external api//

public class Company {
	String companyName;
	String sector;
	String exchange;
	double price;
	// no args constructor//
	public Company() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// parameterised constructor//
	public Company(String companyName, String sector, String exchange,double price) {
		super();
		this.companyName = companyName;
		this.sector = sector;
		this.exchange = exchange;
		this.price=price;
	}
	
	
	// getters and setters for attributes//
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	

}
