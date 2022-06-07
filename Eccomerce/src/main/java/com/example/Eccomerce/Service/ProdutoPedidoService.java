package com.example.Eccomerce.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Exception.ProdutoForaDeEstoqueException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Pedido;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Model.Produtos_Pedidos;
import com.example.Eccomerce.Repository.ProdutoPedidoRepository;

@Service
public class ProdutoPedidoService {

	@Autowired
	ProdutoPedidoRepository repository;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	PedidoService pedidoService;

	public Pedido colocarProduto(Integer id, String nome, Integer quantidade)
			throws ProdutoNotExcepetion, PedidoNaoEcontradoException, ProdutoForaDeEstoqueException {

		Pedido pedido = pedidoService.listarPedido(id);
		Produto produto = produtoService.findByName(nome);
		Optional<Produtos_Pedidos> optional = repository.findByProdutoIdAndPedidoId(produto.getId(), pedido.getId());
		if (quantidade > produto.getQuantidade_estoque()) {
			throw new ProdutoForaDeEstoqueException("O estoque é insuficiente para este pedido");
		} else {
			if (optional.isPresent()) {
				optional.get().setQuantidade(quantidade + optional.get().getQuantidade());
				produto.setQuantidade_estoque(produto.getQuantidade_estoque() - quantidade);
				produtoService.salvarProduto(produto);
				repository.save(optional.get());
				return pedidoService.listarPedido(id);
			} else {
				Produtos_Pedidos produtoPedido = new Produtos_Pedidos();

				produtoPedido.setPreco(produto.getPreco());
				produtoPedido.setQuantidade(quantidade);
				produto.setQuantidade_estoque(produto.getQuantidade_estoque() - quantidade);
				produtoService.salvarProduto(produto);
				List<Produtos_Pedidos> list = new ArrayList<Produtos_Pedidos>();
				list.add(produtoPedido);
				pedido.setProdutoPedido(list);
				repository.save(produtoPedido);
				pedidoService.salvarPedido(pedido);
				return pedido;
			}
		}
	}
}