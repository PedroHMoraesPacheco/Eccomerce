+package com.example.Eccomerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Service.ProdutoService;

@RestController
@RequestMapping("/produto")

public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	// Visualizar todos os produtos.
	@GetMapping()
	public List<Produto> getAll(){
		return service.listarTudo();
	}
	
	// Visualizar um específico pelo nome.
	@GetMapping(path = "/(nome)")
	public Produto getOne(@PathVariable(name = "Nome")String nome) {
		return service.findByName(nome);
	}
	
	
	// Criar um novo produto (Com imagem).
	@PostMapping()
	public void create(@RequestBody Produto produto) {
		service.create(produto,Multpartfile);
	
	// Editar um produto.
	@PutMapping("/{id}")
	public Produto update(@PathVariable Integer id, @RequestBody Produto produto) {
		return service.update(produto, null);
	}
	
	// Deletar um produto.
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id)}
	service.delete(id);
}