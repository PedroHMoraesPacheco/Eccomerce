package com.example.Eccomerce.DTO;

import java.util.Date;

import com.example.Eccomerce.Model.Produto;

public class ProdutoDTO {
	
	
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade_estoque;
	private Date data_cadastro_produto;
	private String imagem_url;
	private Integer categoriaId;
	private Integer funcionarioId;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj, String url) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
		this.quantidade_estoque = obj.getQuantidade_estoque();
		this.data_cadastro_produto = obj.getData_cadastro_produto();
		this.categoriaId = obj.getCategoria_id().getId();
		this.funcionarioId = obj.getFuncionario_id().getId();
		this.imagem_url = url;
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

	public String getImagem_url() {
		return imagem_url;
	}

	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
	
}