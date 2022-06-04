package com.example.Eccomerce.DTO;

import java.util.Date;

import com.example.Eccomerce.Model.Imagem;

public class ProdutoDTO {
	
	
	private Integer id;
	private String descricao;
	private Double preco;
	private Integer quantidade_estoque;
	private Date data_cadastro_produto;
	private Imagem imagem_id;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer id, String descricao, Double preco, Integer quantidade_estoque,
			Date data_cadastro_produto, Imagem imagem_id) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade_estoque = quantidade_estoque;
		this.data_cadastro_produto = data_cadastro_produto;
		this.imagem_id = imagem_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	
}