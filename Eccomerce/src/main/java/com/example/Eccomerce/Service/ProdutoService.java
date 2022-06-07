package com.example.Eccomerce.Service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Eccomerce.Exception.CategoriaNaoEcontradaException;
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
	
	@Autowired
	FuncionarioService funciService;
	
	@Autowired
	CategoriaService categoriaService;
	
	public List<Produto> listarTudo(){
			return repository.findAll();
	}
	public void salvarProduto(Produto produto) {
		repository.save(produto);
	}
	public Produto findByName(String nome) throws ProdutoNotExcepetion {
		Optional<Produto> optional = repository.findByNome(nome);
		if(optional.isEmpty() ) {
			throw new ProdutoNotExcepetion("Produto não existe");
		}
		return optional.get();
}
	
	public void verificarProdutoExiste(Produto produto) throws ProdutoExisteException {
		Optional<Produto> optional = repository.findByNome(produto.getNome());
		if(optional.isPresent()) {
		throw new ProdutoExisteException("Produto já cadastrado!");
		}
	}
	
	public void create(Produto produto, MultipartFile file) throws IOException, ProdutoExisteException {
		verificarProdutoExiste(produto);
		produto.setData_cadastro_produto(LocalDate.now());
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
		produtodto.setImagem_url(imagemService.createUrl(produto.getId()));
		return produtodto;
	}
	
	public Produto TrasformaDto(ProdutoDTO produtodto) throws CategoriaNaoEcontradaException {
		Produto produto=new Produto();
		produto.setNome(produtodto.getNome());
		produto.setPreco(produtodto.getPreco());
		produto.setDescricao(produtodto.getDescricao());
		produto.setQuantidade_estoque(produtodto.getQuantidade_estoque());
		produto.setData_cadastro_produto(produtodto.getData_cadastro_produto());
		produto.setFuncionario_id(funciService.funcionarioByID(produtodto.getFuncionarioId()));
		produto.setCategoria_id(categoriaService.listarCategoria(produtodto.getCategoriaId()));
		produtodto.setImagem_url(imagemService.createUrl(produto.getId()));
		return produto;
	}
}