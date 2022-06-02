package com.example.Eccomerce.Exception;

public class PedidoNaoEcontradoException extends Exception {
	
	private String Message;

	public PedidoNaoEcontradoException(String message) {
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
