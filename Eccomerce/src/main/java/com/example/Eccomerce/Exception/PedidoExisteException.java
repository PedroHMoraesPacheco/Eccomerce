package com.example.Eccomerce.Exception;

public class PedidoExisteException extends Exception{
	
	private String Message;

	public PedidoExisteException(String message) {
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
