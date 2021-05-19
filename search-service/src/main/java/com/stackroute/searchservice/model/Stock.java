package com.stackroute.searchservice.model;


//this particular class is for defining symbols with company attributes//

public class Stock {
    String symbol;
    Historical historical[];
    // no args constructor//
	public Stock() {
		super();
	}
	
	// parameterized constructor//
	
	public Stock(String symbol, Historical[] historical) {
		super();
		this.symbol = symbol;
		this.historical = historical;
	}
    
	// getter and setters//
	

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Historical[] getHistorical() {
		return historical;
	}
	public void setHistorical(Historical[] historical) {
		this.historical = historical;
	}
    
}
