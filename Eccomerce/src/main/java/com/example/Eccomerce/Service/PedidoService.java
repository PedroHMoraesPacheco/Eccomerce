package com.example.Eccomerce.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.PedidoDTO;
import com.example.Eccomerce.Exception.PedidoExisteException;
import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Model.Pedido;
import com.example.Eccomerce.Repository.PedidoRepository;


@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoR;

	//get
	public Pedido listarPedido(Integer id) throws PedidoNaoEcontradoException {
		Optional<Pedido> optional = pedidoR.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoNaoEcontradoException("O Produto não foi encontrado!");
		}
		return optional.get();
	}
	
	
	public void verificarPedidoExiste(Pedido pedido) throws PedidoExisteException {
		Optional<Pedido> optional = pedidoR.findById(pedido.getId());
		if (optional.isPresent()) {
			throw new PedidoExisteException("Pedido já cadastrado!");
		}
	}
	
	//post
	public void criarPedido(Pedido pedido) throws PedidoExisteException {
		verificarPedidoExiste(pedido);
		pedidoR.save(pedido);
	}

	
	//delete
	public void deletarPedido(Integer id) throws PedidoNaoEcontradoException {
		Optional<Pedido> optional = pedidoR.findById(id);

		if (optional.isEmpty()) {
			throw new PedidoNaoEcontradoException("O Pedido não foi encontrado!");
		}
		pedidoR.deleteById(id);
	}
	
	//put
	public Pedido editarPedido(Pedido pedido, Integer id) throws PedidoExisteException, PedidoNaoEcontradoException {
		Optional<Pedido> optional = pedidoR.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoNaoEcontradoException("O Pedido não foi encontrado!");
		}
		Pedido pedidoOld = optional.get();
		if (!pedido.getNumeroPedido().equals("") && pedido.getId() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setNumeroPedido(pedido.getNumeroPedido());
		}
		return pedidoR.save(pedido);
	}
	
	
}
