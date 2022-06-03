package com.example.Eccomerce.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Usuario") 
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "Username")
	private String username;
	
	
	@Column(name = "Email")
	private String email;
	
	
	@Column(name = "Senha")
	private String senha;
	
	
	@Column(name = "Role")
	private String role;

	@OneToOne(mappedBy="cliente")
	private Cliente cliente;
	
	@OneToOne(mappedBy="funcionario")
	private Funcionario funcionario;
	
	public User() {
		super();
	}

	public User(Integer id,  String username, String email,
			 String senha,  String role, Cliente cliente, Funcionario funcionario) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.role = role;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	
}
