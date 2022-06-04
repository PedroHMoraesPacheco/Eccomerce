package com.example.Eccomerce.Exception;

public class CategoriaExisteException extends Exception {

	private String Message;

	public CategoriaExisteException(String message) {
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
