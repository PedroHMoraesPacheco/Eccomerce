package com.example.Eccomerce.Model;

public class Mail {
	public String from;
	public String para;
	public String assunto;
	public String texto;

	public Mail() {
		super();
	}

	public Mail(String from, String para, String assunto, String texto) {
		super();
		this.from = from;
		this.para = para;
		this.assunto = assunto;
		this.texto = texto;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
