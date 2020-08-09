package com.modul_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.*;
import org.mockito.Mockito;

public class VatServiceTest {
	VatService vatService;
	VatProvider vatProvider;
	
	@Test
	public void shouldCalculateGrossPriceForDefaultVat() throws Exception {
		// given
		Product product = generateProduct("1", 20.00, "T-Shirt");
		Mockito.when(vatProvider.getDefaultVat()).thenReturn(0.23);
		
		// when
		double result = vatService.getGrossPriceForDefaultVat(product);
		
		// then
		assertThat(result).isEqualTo(24.60);}

	@Test
	public void shouldCalculateGrossPriceForOtherVatValue() throws Exception {
		// given
		String type = "Book";
		Product product = generateProduct("2", 10.00, type);
		Mockito.when(vatProvider.getVatForType(type)).thenReturn(0.08);
		
		// when
		double result = vatService.getGrossPrice(product.getNetPrice(), type);
		
		// then
		assertThat(result).isEqualTo(10.80);}

	@Test
	public void shouldThrowExceptionWhenVatIsTooHigh() {
		// given
		String type = "Book";
		Product product = generateProduct("3", 10.00, type);
		Mockito.when(vatProvider.getVatForType(type)).thenReturn(1.0);
		
		// then
		assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
			vatService.getGrossPrice(product.getNetPrice(), type);
		});
	}

	private Product generateProduct(String id, double netPrice, String type) {
		return new Product(id, netPrice, type);
	}
	
	@Before
	public void prepareVatService() {
		vatProvider = Mockito.mock(VatProvider.class);
		vatService = new VatService(vatProvider);
	}
}