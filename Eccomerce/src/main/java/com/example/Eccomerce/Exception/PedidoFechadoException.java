package com.example.Eccomerce.Exception;

public class PedidoFechadoException extends Exception {
	
	private String mensagem;

	public PedidoFechadoException(String mensagem) {
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
