package br.com.serratec.Exceptions;

public class CategoriaInvalidaException extends Exception {
	
	private String mensagem;

	public CategoriaInvalidaException(String mensagem) {
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
