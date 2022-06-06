package com.example.Eccomerce.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private Integer numeroPedido;

	@NotBlank
	private Double valorTotal;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_pedido")
	private LocalDate dataPedido;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;
	private String status;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente_id;

	@OneToMany(mappedBy = "pedido_id",cascade = CascadeType.ALL)
	private List<Produtos_Pedidos> produtoPedido;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, Integer numeroPedido, Double valorTotal, LocalDate dataPedido, LocalDate dataEntrega,
			String status, Cliente cliente_id, Funcionario funcionario_id, List<Produtos_Pedidos> produtoPedido) {
		super();
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.status = status;
		this.cliente_id = cliente_id;
		this.produtoPedido = produtoPedido;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Produtos_Pedidos> getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(List<Produtos_Pedidos> produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public Integer getId() {
		return id;
	}

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

}
