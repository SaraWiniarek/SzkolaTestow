package com.modul_2;

public interface VatProvider {
	double getDefaultVat();	
	double getVatForType(String type);
}