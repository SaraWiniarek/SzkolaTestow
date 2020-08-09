package com.modul_2;

public class VatService {
//	double vatValue;
//	public VatService() {
//		this.vatValue = 0.23;
//	}
	
	VatProvider vatProvider;
	
	public VatService(VatProvider vatProvider) {
		this.vatProvider = vatProvider;
	}
	
	public double getGrossPriceForDefaultVat(Product product) throws Exception {
		return calculateGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
	}
	
	public double getGrossPrice(double netPrice, String productType) throws Exception {
		double vatValue = vatProvider.getVatForType(productType);
		return calculateGrossPrice(netPrice, vatValue);
	}
	
	private double calculateGrossPrice(double netPrice, double vatValue) throws Exception {
		if(vatValue >= 1)
			throw new Exception("VAT must be lower!");
		return netPrice * (1 + vatValue);
	}
}