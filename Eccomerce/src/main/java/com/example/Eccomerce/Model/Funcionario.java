package com.example.Eccomerce.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	
}
