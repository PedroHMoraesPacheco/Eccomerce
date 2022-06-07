package com.example.Eccomerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.PedidoDTO;
import com.example.Eccomerce.Exception.PedidoExisteException;
import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Model.Pedido;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoR;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ProdutoPedidoService produtopedidoS;

	public Pedido TransformaPedidoDto(PedidoDTO pedidoDto) {
		Pedido novoPedido = new Pedido();
		novoPedido.setNumeroPedido(pedidoDto.getNumeroPedido());
		novoPedido.setValorTotal(pedidoDto.getValorTotal());
		novoPedido.setStatus(pedidoDto.getStatus());
		novoPedido.setDataPedido(pedidoDto.getDataPedido());
		novoPedido.setDataEntrega(pedidoDto.getDataEntrega());
		pedidoR.save(novoPedido);
		return novoPedido;
	}

	public void salvarPedido(Pedido pedido) {
		pedidoR.save(pedido);
	}
	
	public List<Pedido> listarTudo() {
		return pedidoR.findAll();
	}

	// get
	public Pedido listarPedido(Integer id) throws PedidoNaoEcontradoException {
		Pedido optional = pedidoR.findById(id).get();
		if (optional==null) {
			throw new PedidoNaoEcontradoException("O Produto não foi encontrado!");
		}
		return optional;
	}

	public void verificarPedidoExiste(Pedido pedido) throws PedidoExisteException {
		Optional<Pedido> optional = pedidoR.findById(pedido.getId());
		if (optional.isPresent()) {
			throw new PedidoExisteException("Pedido já cadastrado!");
		}
	}

	// post
	public void criarPedido(Pedido pedido) throws PedidoExisteException {
		verificarPedidoExiste(pedido);
		pedidoR.save(pedido);
	}

	// delete
	public void deletarPedido(Integer id) throws PedidoNaoEcontradoException {
		Optional<Pedido> optional = pedidoR.findById(id);

		if (optional.isEmpty()) {
			throw new PedidoNaoEcontradoException("O Pedido não foi encontrado!");
		}
		pedidoR.deleteById(id);
	}

	// put
	public Pedido editarPedido(Pedido pedido, Integer id) throws PedidoExisteException, PedidoNaoEcontradoException {
		Optional<Pedido> optional = pedidoR.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoNaoEcontradoException("O Pedido não foi encontrado!");
		}
		Pedido pedidoOld = optional.get();
		if (pedido.getNumeroPedido() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setNumeroPedido(pedido.getNumeroPedido());
		}
		if (!pedido.getStatus().equals("") && pedido.getStatus() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setStatus(pedido.getStatus());
			;
		}
		if (pedido.getDataEntrega() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setDataEntrega(pedido.getDataEntrega());
		}
		if (pedido.getDataPedido() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setDataPedido(pedido.getDataPedido());
		}
		if (pedido.getValorTotal() != null) {
			verificarPedidoExiste(pedido);
			pedidoOld.setValorTotal(pedido.getValorTotal());
		}

		return pedidoR.save(pedido);
	}
	public Pedido CriarPedido(Integer id, Integer quantidade, String nome) throws ProdutoNotExcepetion, PedidoNaoEcontradoException {
		Pedido pedido=new Pedido();
		Cliente cliente = clienteService.findClienteByid(id);
		pedido.setCliente_id(cliente);
		Double valorTotal=produtoService.findByName(nome).getPreco()*quantidade;
		System.out.println(valorTotal);
		pedido.setValorTotal(valorTotal);
		Pedido pedidosaved = pedidoR.save(pedido);
		produtopedidoS.colocarProduto(pedidosaved.getId(), nome, quantidade);
		return pedido;
	}
}
