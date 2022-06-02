package com.example.Eccomerce.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private	String nome;
	private String cpf;
	private String telefone;
	private Date dataDeNascimento;
	
	@OneToOne
	@JoinColumn(name = "Funcionario_id")
	private User funcionario;
	
	@OneToMany(mappedBy="funcionario_Produto")
	private List<Produto> produto;

	public Funcionario(Integer id, String nome, String cpf, String telefone, Date dataDeNascimento, User funcionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		this.funcionario = funcionario;
	}

	public Funcionario() {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public User getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(User funcionario) {
		this.funcionario = funcionario;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	
	
}
