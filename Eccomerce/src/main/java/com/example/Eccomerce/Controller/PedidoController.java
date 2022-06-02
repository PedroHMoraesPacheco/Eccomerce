package com.example.Eccomerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eccomerce.PedidoDTO;
import com.example.Eccomerce.Exception.PedidoExisteException;
import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService service;

	@GetMapping("{numeroPedido}")
	public PedidoDTO getOne(@PathVariable Integer numeroPedido) throws PedidoNaoEcontradoException {
		return service.listarPedido(numeroPedido);
	}

	@PutMapping("/{numeroPedido}")
	public PedidoDTO update(@RequestBody PedidoDTO pedido, @PathVariable Integer numeroPedido)
			throws PedidoNaoEcontradoException, PedidoExisteException {
		return service.editarPedido(pedido, numeroPedido);
	}

	@DeleteMapping("/{numeroPedido}")
	public void delete(@PathVariable Integer numeroPedido) throws PedidoNaoEcontradoException {
		service.deletarPedido(numeroPedido);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody PedidoDTO pedido) throws PedidoExisteException {
		service.criarPedido(pedido);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
