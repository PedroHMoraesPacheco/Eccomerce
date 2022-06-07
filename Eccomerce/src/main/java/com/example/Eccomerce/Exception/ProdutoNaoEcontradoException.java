package com.example.Eccomerce.Exception;

public class ProdutoNaoEcontradoException extends Exception{
	
	private String mensagem;

	public ProdutoNaoEcontradoException(String mensagem) {
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
