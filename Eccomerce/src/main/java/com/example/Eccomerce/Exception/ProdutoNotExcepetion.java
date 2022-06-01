package com.example.Eccomerce.Exception;

public class ProdutoNotExcepetion extends Exception {
	
	private String message;

	public ProdutoNotExcepetion(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
