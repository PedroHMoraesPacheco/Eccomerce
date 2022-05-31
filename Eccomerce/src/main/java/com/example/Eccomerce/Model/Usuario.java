package com.example.Eccomerce.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	
	private String username;
	
	private String nome;
		
	private String senha;
	
	private String cpf;
	
	private String endereco;
	
	private String telefone;
	
	xxxxx xxxxx tipo; ???????
}
