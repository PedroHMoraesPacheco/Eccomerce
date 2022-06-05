package com.example.Eccomerce.Service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Eccomerce.Exception.ProdutoExisteException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.DTO.ProdutoDTO;
import com.example.Eccomerce.Repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	@Autowired 
	ImagemService imagemService;
	
	public List<Produto> listarTudo(){
			return repository.findAll();
	}
		
	public Produto findByName(String nome) throws ProdutoNotExcepetion {
		Optional<Produto> optional = repository.findByNome(nome);
		if(optional.isEmpty() ) {
			throw new ProdutoNotExcepetion("Produto não existe");
		}
		return optional.get();
}
	
	public void verificarProdutoExiste(Produto produto) throws ProdutoExisteException {
		Optional<Produto> optional = repository.findById(produto.getId());
		if(optional.isPresent()) {
		throw new ProdutoExisteException("Produto já cadastrado!");
		}
	}
	
	public void create(Produto produto, MultipartFile file) throws IOException, ProdutoExisteException {
		verificarProdutoExiste(produto);
		Produto savedProduto = repository.save(produto);
		imagemService.create(savedProduto, file);
	}
	
	
	public Produto update(ProdutoDTO novoProduto, Integer id) throws ProdutoNotExcepetion {
		Produto oldProduto = repository.findById(id).get();
		
			if(novoProduto.getNome()!= null) {
				oldProduto.setNome(novoProduto.getNome());
			}
			if(novoProduto.getDescricao()!= null) {
				oldProduto.setDescricao(novoProduto.getDescricao());
			}
			if(novoProduto.getPreco()!= null) {
				oldProduto.setPreco(novoProduto.getPreco());
			}
			if(novoProduto.getQuantidade_estoque()!= null) {
				oldProduto.setQuantidade_estoque(novoProduto.getQuantidade_estoque());
			}
			if(novoProduto.getData_cadastro_produto()!= null) {
				oldProduto.setData_cadastro_produto(novoProduto.getData_cadastro_produto());
			}
		return repository.save(oldProduto);
	}
	
	public void delete(Integer id) throws ProdutoNotExcepetion {
		Optional<Produto> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNotExcepetion ("O Produto não foi encontrado!");
		}
		repository.delete(optional.get());
	}
	
	public ProdutoDTO getProdutoDto(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("produto/{id}/imagem")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoDTO produtodto=new ProdutoDTO();
		produtodto.setNome(produto.getNome());
		produtodto.setDescricao(produto.getDescricao());
		produtodto.setPreco(produto.getPreco());
		produtodto.setQuantidade_estoque(produto.getQuantidade_estoque());
		produtodto.setCategoriaId(produto.getCategoria_id().getId());
		produtodto.setFuncionarioId(produto.getFuncionario_id().getId());
		produtodto.setImagem_url(uri.toString());
		return produtodto;
	}
}