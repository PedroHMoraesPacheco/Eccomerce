package com.example.Eccomerce.Service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.ProdutoRepositorio;

import br.com.serratec.Exceptions.ProdutoJaExisteException;
import br.com.serratec.Exceptions.ProdutoNaoEcontradoException;



@Service
public class ProdutoService {

	@Autowired
	ProdutoRepositorio repositorio;
	
	public List<Produto> listarTudo() {
		return repositorio.findAll();
	}
	
	public Produto listarProduto(String id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
		}
		return optional.get();
	}
	
	public void verificarProduto(Produto produto) throws ProdutoJaExisteException {
		Optional<Produto> optional = repositorio.findById(produto.getId());
		if (optional.isPresent()) {
			throw new ProdutoJaExisteException("Produto já Existente!");
		}
	}

	public void inserirProduto(Produto produto) throws ProdutoJaExisteException {
		verificarProduto(produto);
		repositorio.save(produto);
	}
	
	public void deletarProduto(String id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
		}
		repositorio.deleteById(id);
	}
	
	
}
