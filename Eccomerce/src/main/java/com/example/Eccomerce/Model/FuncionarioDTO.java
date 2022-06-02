package com.example.Eccomerce.Model;

import java.util.Date;

public class FuncionarioDTO {
	private Integer id;
	private String nome;
	private String email;
	private String username;
	private String senha;
	private String cpf;
	private String telefone;
	private Date data;
	
	public FuncionarioDTO(Integer id, String nome, String email, String username, String senha, String cpf,
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

	public FuncionarioDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
