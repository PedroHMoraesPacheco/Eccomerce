package com.example.Eccomerce.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.html.HTML;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private Integer QuantidadeEstoque;
	
	private LocalDate DataCadastroProduto;
	
	private String categoria_id;
	
	private HTML imagem;
	
	private String funcionario_id;

	public Produto() {
		super();
	}

	public Produto(String id, String nome, String descricao, Double preco, Integer quantidadeEstoque,
			LocalDate dataCadastroProduto, String categoria_id, HTML imagem, String funcionario_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		QuantidadeEstoque = quantidadeEstoque;
		DataCadastroProduto = dataCadastroProduto;
		this.categoria_id = categoria_id;
		this.imagem = imagem;
		this.funcionario_id = funcionario_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}

	public HTML getImagem() {
		return imagem;
	}

	public void setImagem(HTML imagem) {
		this.imagem = imagem;
	}

	public String getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(String funcionario_id) {
		this.funcionario_id = funcionario_id;
	}






 

}
