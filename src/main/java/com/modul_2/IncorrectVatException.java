package com.modul_2;

public class IncorrectVatException extends Throwable {
	private String message;
	
	public IncorrectVatException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}