package com.example.Eccomerce.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy ="categoria_Produto")
	private List<Produto> produto;

	public Categoria() {
		super();
	}

	

	public Categoria(Integer id, String nome, String descricao, List<Produto> produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.produto = produto;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Produto> getProduto() {
		return produto;
	}



	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}



	public Integer getId() {
		return id;
	}
}
