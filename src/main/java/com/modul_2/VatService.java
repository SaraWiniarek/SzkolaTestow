package com.modul_2;

import java.math.*;

public class VatService {
//	BigDecimal vatValue;
//	
//	public VatService() {
//		this.vatValue = new BigDecimal("0.23");
//	}
	
	VatProvider vatProvider; //zewnêtrzny interface, aby móc u¿yæ zaœlepek
	
	public VatService(VatProvider vatProvider) {
		this.vatProvider = vatProvider;
	}
	
	public BigDecimal getGrossPriceForDefaultVat(Product product) throws Exception {
		return calculateGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
	}
	
	public BigDecimal getGrossPrice(BigDecimal netPrice, String productType) throws Exception {
		BigDecimal vatValue = vatProvider.getVatForType(productType);
		return calculateGrossPrice(netPrice, vatValue);
	}
	
	private BigDecimal calculateGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws Exception {
	MathContext m = new MathContext(4);
	if(vatValue.compareTo(BigDecimal.ONE) == 1)
		throw new Exception("VAT must be lower!");
	
	return netPrice.multiply((vatValue).add(BigDecimal.ONE)).round(m);
	}
	
	
}