package com.example.Eccomerce.Service;

import java.util.List;
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Eccomerce.Exception.ProdutoExisteException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	public List<Produto> listarTudo(){
			return repository.findAll();
	}
		
	public Produto findByName(String nome) throws ProdutoNotExcepetion {
		Optional<Produto> optional = repository.findByName(nome);
		if(optional.isEmpty() ) {
			throw new ProdutoNotExcepetion("Produto não existe");
=======
>>>>>>> Stashed changes



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
	
	public Produto listarProduto(Integer id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
<<<<<<< Updated upstream
=======
>>>>>>> b12504aaf21239cdb7844ef0d39a735e11aa2a01
>>>>>>> Stashed changes
		}
		return optional.get();
	}
	
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	public void verificarProdutoExiste(Produto produto) throws ProdutoExisteException {
		Optional<Produto> optional = repository.findById(produto.getId());
		if(optional.isPresent()) {
		throw new ProdutoExisteException("Produto já cadastrado!");
		}
	}
	
	
		
=======
>>>>>>> Stashed changes
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
	
	public void deletarProduto(Integer id) throws ProdutoNaoEcontradoException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNaoEcontradoException("O Produto não foi encontrado!");
		}
		repositorio.deleteById(id);
	}
	
	
<<<<<<< Updated upstream
=======
>>>>>>> b12504aaf21239cdb7844ef0d39a735e11aa2a01
>>>>>>> Stashed changes
}
