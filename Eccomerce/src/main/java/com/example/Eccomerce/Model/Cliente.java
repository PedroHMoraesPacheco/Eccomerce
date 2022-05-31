package com.example.Eccomerce.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@NotNull
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@NotEmpty
	@NotNull
	@Column(name = "Email", nullable = false)
	private String email;
	
	@NotEmpty
	@NotNull
	@Column(name = "Username", nullable = false)
	private String username;
	
	@NotEmpty
	@NotNull
	@Column(name = "Senha", nullable = false)
	private String senha;
	@NotEmpty
	@NotNull
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "Telefone")
	private String telefone;
	
	@Column(name = "Data de Nascimento", nullable = false, length = 20)
	@Temporal(TemporalType.DATE)
	private Date data;

	@NotEmpty
	@NotNull
	@Column(name = "Endereço", nullable = false)
	private Endereco endereco;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, @NotEmpty @NotNull String nome, @NotEmpty @NotNull String email,
			@NotEmpty @NotNull String username, @NotEmpty @NotNull String senha, @NotEmpty @NotNull String cpf,
			String telefone, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.data = data;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
