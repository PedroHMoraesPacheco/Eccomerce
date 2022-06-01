package br.com.serratec.Exceptions;

public class ProdutoInvalidoException extends Exception{
	
	private String mensagem;

	public ProdutoInvalidoException(String mensagem) {
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
