package com.example.Eccomerce.Controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.example.Eccomerce.DTO.PedidoDTO;
import com.example.Eccomerce.Exception.PedidoExisteException;
import com.example.Eccomerce.Exception.PedidoFechadoException;
import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Exception.ProdutoForaDeEstoqueException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Pedido;
import com.example.Eccomerce.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService service;

	@GetMapping()
	public List<PedidoDTO> listAll() {
		List<Pedido> list = service.listarTudo();
		List<PedidoDTO> listDTO = list.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}

	@GetMapping("{id}")
	public Pedido getOne(@PathVariable Integer id) throws PedidoNaoEcontradoException {
		return service.listarPedido(id);
	}

	@PutMapping("/{id}")
	public PedidoDTO update(@RequestBody PedidoDTO pedido, @PathVariable Integer id)
			throws PedidoNaoEcontradoException, PedidoExisteException {
		service.editarPedido(service.TransformaPedidoDto(pedido), id);
		return pedido;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws PedidoNaoEcontradoException {
		service.deletarPedido(id);
	}

	@PostMapping("/compra/{id}/{nome}/{quantidade}")
	public Pedido criarPedido(@PathVariable Integer id,@PathVariable String nome,@PathVariable Integer quantidade) throws ProdutoNotExcepetion, PedidoNaoEcontradoException, ProdutoForaDeEstoqueException {
		return service.CriarPedido(id, quantidade, nome);
	}
	@PutMapping("/fechar/{id}")
	public void fecharPedido(@PathVariable Integer id) {
		service.fecharPedido(id);
	}
	@PostMapping("/adicionar/{idPedido}/{nome}/{quantidade}")
	public Pedido adicionarProduto(@PathVariable Integer idPedido,@PathVariable String nome,@PathVariable Integer quantidade) throws PedidoNaoEcontradoException, PedidoFechadoException, ProdutoNotExcepetion, ProdutoForaDeEstoqueException {
		return service.adicionarPedido(idPedido, quantidade, nome);
	}
}
