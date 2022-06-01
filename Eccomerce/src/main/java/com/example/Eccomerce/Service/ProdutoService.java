package com.example.Eccomerce.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Eccomerce.Exception.ProdutoExisteException;
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
	
	public Produto listarProduto(Integer id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
		}
		return optional.get();
	}
	
	public void verificarProdutoExiste(Produto produto) throws ProdutoExisteException {
		Optional<Produto> optional = repositorio.findById(produto.getId());
		if(optional.isPresent()) {
		throw new ProdutoExisteException("Produto já cadastrado!");
		}
	}

	public void inserirProduto(Produto produto) throws ProdutoJaExisteException, ProdutoExisteException {
		verificarProdutoExiste(produto);
		repositorio.save(produto);
	}
	
	public void deletarProduto(Integer id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
		}
		repositorio.deleteById(id);
	}
}
