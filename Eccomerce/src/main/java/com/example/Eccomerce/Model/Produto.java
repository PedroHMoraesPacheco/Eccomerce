package com.example.Eccomerce.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private Integer quantidade_estoque;
	
	private Date data_cadastro_produto;
	
	@Lob
    @Column(name = "imagem", columnDefinition="BLOB")
    private byte[] imagem;
	
	//@OneToOne
	//@JoinColumn(name = "imagem")
	//private Imagem imagem_id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Categoria categoria_id;

	@ManyToOne
	@JoinColumn(name = "id")
	private Funcionario funcionario_id;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String descricao, Double preco, Integer quantidade_estoque,
			Date data_cadastro_produto, Imagem imagem_id, Categoria categoria_id, Funcionario funcionario_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade_estoque = quantidade_estoque;
		this.data_cadastro_produto = data_cadastro_produto;
		this.imagem_id = imagem_id;
		this.categoria_id = categoria_id;
		this.funcionario_id = funcionario_id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public Date getData_cadastro_produto() {
		return data_cadastro_produto;
	}

	public void setData_cadastro_produto(Date data_cadastro_produto) {
		this.data_cadastro_produto = data_cadastro_produto;
	}

	public Imagem getImagem_id() {
		return imagem_id;
	}

	public void setImagem_id(Imagem imagem_id) {
		this.imagem_id = imagem_id;
	}

	public Categoria getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Funcionario getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(Funcionario funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
}
	

