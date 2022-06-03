package com.example.Eccomerce.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "Rua")
	private String logradouro;
	
	@Column(name = "Bairro")
	private String bairro;
	
	@Column(name = "Cidade")
	private String localidade;
	
	@Column(name = "Numero")
	private String siafi;
	
	@Column(name = "Complemento")
	private String complemento;
	
	@Column(name = "Estado")
	private String uf;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente_id;

	public Endereco() {
		super();
	}

	public Endereco(Integer id, String cep, String logradouro, String bairro, String localidade, String siafi,
			String complemento, String uf, Cliente cliente_id) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.siafi = siafi;
		this.complemento = complemento;
		this.uf = uf;
		this.cliente_id = cliente_id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return localidade;
	}

	public void setCidade(String localidade) {
		this.localidade = localidade;
	}

	public String getNumero() {
		return siafi;
	}

	public void setNumero(String siafi) {
		this.siafi = siafi;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return uf;
	}

	public void setEstado(String uf) {
		this.uf = uf;
	}

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Integer getId() {
		return id;
	}
	
}
