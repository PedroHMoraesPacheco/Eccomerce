package com.example.Eccomerce.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.Eccomerce.Model.Pedido;

public class PedidoDTO {
	
	@NotNull
	private Integer id;
	
	@NotNull
	private Integer numeroPedido;
	
	@NotBlank
	private Double valorTotal;
	
	@NotBlank
	private String status;

	@NotBlank
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataPedido;
	
	@NotBlank
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataEntrega;

	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.numeroPedido = pedido.getNumeroPedido();
		this.valorTotal = pedido.getValorTotal();
		this.dataPedido = pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.status =pedido.getStatus();
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

	public Integer getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	


}
