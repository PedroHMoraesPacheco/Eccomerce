package com.example.Eccomerce.Exception;

public class InvalidoCpfException extends Exception {

	private String mensagem;

	public InvalidoCpfException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
