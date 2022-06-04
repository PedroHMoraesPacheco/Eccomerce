package com.example.Eccomerce.DTO;

import javax.validation.constraints.NotNull;

import com.example.Eccomerce.Model.Categoria;

public class CategoriaDTO {

	@NotNull
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;
	@NotNull
	private Integer numeroCategoria;

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		this.numeroCategoria = categoria.getNumeroCategoria();
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

	public Integer getNumeroCategoria() {
		return numeroCategoria;
	}

	public void setNumeroCategoria(Integer numeroCategoria) {
		this.numeroCategoria = numeroCategoria;
	}

}
