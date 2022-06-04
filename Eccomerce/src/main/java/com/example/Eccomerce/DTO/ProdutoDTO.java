package com.example.Eccomerce.DTO;

import java.util.Date;

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

	
}