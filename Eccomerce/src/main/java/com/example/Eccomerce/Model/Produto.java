package com.example.Eccomerce.Model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private Integer QuantidadeEstoque;
	
	private LocalDate DataCadastroProduto;
	
	
	@ManyToOne
	@JoinColumn(name="categoria_id", referencedColumnName="id")
	private Categoria categoria_Produto;

	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario_Produto;
	
	@OneToMany(mappedBy = "produto_id")
	private List<Produtos_Pedidos> produtoPedido;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String descricao, Double preco, Integer quantidadeEstoque,
			LocalDate dataCadastroProduto, Categoria categoria_Produto, Funcionario funcionario_Produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		QuantidadeEstoque = quantidadeEstoque;
		DataCadastroProduto = dataCadastroProduto;
		this.categoria_Produto = categoria_Produto;
		this.funcionario_Produto = funcionario_Produto;
	}

	public Integer getId() {
		return id;
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

	public Integer getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}

	public LocalDate getDataCadastroProduto() {
		return DataCadastroProduto;
	}

	public void setDataCadastroProduto(LocalDate dataCadastroProduto) {
		DataCadastroProduto = dataCadastroProduto;
	}

	public Funcionario getFuncionario_Produto() {
		return funcionario_Produto;
	}

	public void setFuncionario_Produto(Funcionario funcionario_Produto) {
		this.funcionario_Produto = funcionario_Produto;
	}
	
}
