package com.example.Eccomerce.DTO;

import java.util.Date;

import com.example.Eccomerce.Model.Funcionario;

public class FuncionarioDTO {
	private Integer id;
	private String nome;
	private String email;
	private String username;
	private String senha;
	private String cpf;
	private String telefone;
	private Date data;
	private String role;
	
	public FuncionarioDTO(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getFuncionario().getEmail();
		this.username = obj.getFuncionario().getUsername();
		this.senha = obj.getFuncionario().getSenha();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.data = obj.getDataDeNascimento();
		this.role = "Funcionario";
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
