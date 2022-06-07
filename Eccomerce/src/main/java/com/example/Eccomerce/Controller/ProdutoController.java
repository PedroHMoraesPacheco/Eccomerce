package com.example.Eccomerce.Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.DTO.ProdutoDTO;
import com.example.Eccomerce.Exception.CategoriaNaoEcontradaException;
import com.example.Eccomerce.Exception.ProdutoExisteException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Model.Imagem;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Service.ImagemService;
import com.example.Eccomerce.Service.ProdutoService;
@RestController
@RequestMapping("/produto")

public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ImagemService imagemService;
	

	@GetMapping()
	public List<ProdutoDTO> getAll(){
		List<Produto> list = produtoService.listarTudo();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}

	@GetMapping(path = "/(nome)")
	public Produto getOne(@PathVariable(name = "Nome")String nome) throws ProdutoNotExcepetion {
		return produtoService.findByName(nome);
	}
	
	@PostMapping
	public void create(@RequestParam MultipartFile file ,@RequestPart ProdutoDTO produtodto) throws IOException, ProdutoExisteException, CategoriaNaoEcontradaException {
		produtoService.create(produtoService.TrasformaDto(produtodto),file);
	}

	@PutMapping("/{id}")
	public Produto update(@PathVariable Integer id, @RequestBody ProdutoDTO produto) throws ProdutoNotExcepetion {
		return produtoService.update(produto, id);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws ProdutoNotExcepetion {
		produtoService.delete(id);
	}
	@GetMapping(path="/{id}/imagem")
	public ResponseEntity<byte[]> getimagem(@PathVariable (name="id") Long produtoId){
		Imagem imagem = imagemService.findImagemByid(produtoId);
		HttpHeaders headers= new HttpHeaders();
		headers.add("content-type", imagem.getMimetype());
		headers.add("content-length", String.valueOf(imagem.getData().length));
		return new ResponseEntity<>(imagem.getData(), headers, HttpStatus.OK);
	}
}