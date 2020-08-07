package com.modul_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.*;
import org.mockito.Mockito;

public class VatServiceTest {
	VatService vatService;
	VatProvider vatProvider;
	
	@Test
	public void shouldCalculateGrossPriceForDefaultVat() throws Exception {
		//given
		Mockito.when(vatProvider.getDefaultVat()).thenReturn(new BigDecimal("0.23"));
		Product product = generateProduct("20.00", "Clothes");
		
		//when
		BigDecimal result = vatService.getGrossPriceForDefaultVat(product);
		
		//then
		assertThat(result).isEqualTo(new BigDecimal("24.60"));
	}
	
	@Test
	public void shouldCalculateGrossPriceForOtherVatValue() throws Exception {
		//given
		String type = "Books";
		Product product = generateProduct("10.00", type);
		//zaœlepiamy metodê, która przyjmuje typ
		Mockito.when(vatProvider.getVatForType(type)).thenReturn(new BigDecimal("0.08"));
		
		//when
		BigDecimal result = vatService.getGrossPrice(product.getNetPrice(), type);
		
		//then
		assertThat(result).isEqualTo(new BigDecimal("10.80"));
	}
	
	@Test
	public void shouldThrowExceptionWhenVatIsTooHigh() {
		//given
		String type = "Clothes";
		Product product = generateProduct("10.00", type);
		Mockito.when(vatProvider.getVatForType(type)).thenReturn(BigDecimal.TEN);
		//then
		assertThatExceptionOfType(Exception.class).isThrownBy(() ->{
			vatService.getGrossPrice(product.getNetPrice(), type);
		});
	}
	
	private Product generateProduct(String vat, String type) {
		return new Product(UUID.randomUUID(), new BigDecimal(vat), type);
	}
	
	@Before
	public void prepareVatService() {
		vatProvider = Mockito.mock(VatProvider.class);
		vatService = new VatService(vatProvider);
	}
}