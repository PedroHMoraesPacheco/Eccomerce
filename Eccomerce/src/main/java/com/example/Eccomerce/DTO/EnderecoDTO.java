package com.example.Eccomerce.DTO;

import com.example.Eccomerce.Model.Endereco;

public class EnderecoDTO {

	private Integer id;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String complemento;
	private String estado;
	
	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Endereco obj) {
		super();
		this.id = obj.getId();
		this.cep = obj.getCep();
		this.rua = obj.getLogradouro();
		this.bairro = obj.getBairro();
		this.cidade = obj.getCidade();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.estado = obj.getEstado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
