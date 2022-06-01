package br.com.serratec.Exceptions;

public class ProdutoJaExisteException extends Exception {
	
	private String mensagem;

	public ProdutoJaExisteException(String mensagem) {
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
