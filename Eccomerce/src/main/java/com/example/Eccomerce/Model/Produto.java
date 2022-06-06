package com.example.Eccomerce.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Double preco;
	
	@NotNull
	private Integer quantidade_estoque;
	
	@NotNull
	private Date data_cadastro_produto;
	
			
	@OneToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria_Produto;

	@OneToMany(mappedBy = "produto_id",cascade = CascadeType.ALL)
	private List<Produtos_Pedidos> produtoPedido;

	@ManyToOne
	@JoinColumn(name="funcionario_id")
    private Funcionario funcionario_Produto;
	

	@OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
	private Imagem imagem_id;
	
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
		this.categoria_Produto = categoria_id;
		this.funcionario_Produto = funcionario_id;
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
		return categoria_Produto;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoria_Produto = categoria_id;
	}

	public Funcionario getFuncionario_id() {
		return funcionario_Produto;
	}

	public void setFuncionario_id(Funcionario funcionario_id) {
		this.funcionario_Produto = funcionario_id;
	}

	
	
}