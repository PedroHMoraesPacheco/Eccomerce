package com.example.Eccomerce.Exception;

public class ProdutoForaDeEstoqueException extends Exception{
	
	private String mensagem;

	public ProdutoForaDeEstoqueException(String mensagem) {
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
