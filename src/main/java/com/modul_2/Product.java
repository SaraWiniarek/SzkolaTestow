package com.modul_2;

public class Product {
	private String id;
	private double netPrice;
	private String type;
	
	public Product(String id, double netPrice, String type) {
		this.id = id;
		this.netPrice = netPrice;
		this.type = type;
	}
	
	public double getNetPrice() {
		return netPrice;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}