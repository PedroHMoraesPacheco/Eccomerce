package com.example.Eccomerce.Exception;

public class CategoriaNaoEcontradaException extends Exception {
	
	private String Message;

	public CategoriaNaoEcontradaException(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}
