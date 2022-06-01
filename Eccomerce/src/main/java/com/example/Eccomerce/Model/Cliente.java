package com.example.Eccomerce.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cliente")
public class Cliente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@NotNull
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@NotEmpty
	@NotNull
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "Telefone")
	private String telefone;
	
	@Column(name = "Data de Nascimento", nullable = false, length = 20)
	@Temporal(TemporalType.DATE)
	private Date dataDeNascimento;

	@NotEmpty
	@NotNull
	@Column(name = "Endereço", nullable = false)
	private Endereco endereco;
	
	@OneToOne
	@JoinColumn(name = "Conta_id")
	private User cliente;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, @NotEmpty @NotNull String nome, @NotEmpty @NotNull String cpf, String telefone,
			Date data, @NotEmpty @NotNull Endereco endereco, User usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataDeNascimento = data;
		this.endereco = endereco;
		this.cliente = usuario;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData() {
		return dataDeNascimento;
	}

	public void setData(Date data) {
		this.dataDeNascimento = data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public User getUsuario() {
		return cliente;
	}

	public void setUsuario(User usuario) {
		this.cliente = usuario;
	}
	
}
