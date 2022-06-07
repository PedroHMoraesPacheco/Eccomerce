package com.example.Eccomerce.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Usuario") 
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "Username")
	private String username;
	
	@NotNull
	@Column(name = "Email")
	private String email;
	
	@NotNull
	@Column(name = "Senha")
	private String senha;
	
	
	@Column(name = "Role")
	private String role;

	@OneToOne(mappedBy="cliente",cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@OneToOne(mappedBy="funcionario",cascade = CascadeType.ALL)
	private Funcionario funcionario;
	
	@OneToMany(mappedBy="usuario",cascade = CascadeType.ALL)
	private List<CodigoSenha> codigo;
	
	public User() {
		super();
	}

	

	public User(Integer id, String username, String email, String senha, String role, Cliente cliente,
			Funcionario funcionario, List<CodigoSenha> codigo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.role = role;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.codigo = codigo;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public List<CodigoSenha> getCodigo() {
		return codigo;
	}



	public void setCodigo(List<CodigoSenha> codigo) {
		this.codigo = codigo;
	}
	
}
