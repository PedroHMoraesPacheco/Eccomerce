package com.example.Eccomerce.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produtos_Pedidos")
public class Produtos_Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer quantidade;
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto_id;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido_id;

	public Produtos_Pedidos() {
		super();
	}

	public Produtos_Pedidos(Integer id, Integer quantidade, Double preco, Produto produto_id, Pedido pedido_id) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto_id = produto_id;
		this.pedido_id = pedido_id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(Produto produto_id) {
		this.produto_id = produto_id;
	}

	public Pedido getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(Pedido pedido_id) {
		this.pedido_id = pedido_id;
	}

	public Integer getId() {
		return id;
	}
	
}

