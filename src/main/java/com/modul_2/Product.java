package com.modul_2;

import java.math.BigDecimal;
import java.util.*;

public class Product {
	private UUID id;
	private BigDecimal netPrice;
	String type;
	
	public Product(UUID id, BigDecimal netPrice, String type) {
		this.id = id;
		this.netPrice = netPrice;
		this.type = type;
	}
	
	public BigDecimal getNetPrice() {
		return netPrice;
	}
}