package com.stackroute.searchservice.model;

public class Historical {
	
	String Date;
	double open;
	double close;
	double volume;
	public Historical() {
		super();
	}
	public Historical(String date, double open, double close, double volume) {
		super();
		Date = date;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	

}
