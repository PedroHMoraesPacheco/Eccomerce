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

import com.example.Eccomerce.DTO.CategoriaDTO;
import com.example.Eccomerce.Exception.CategoriaExisteException;
import com.example.Eccomerce.Exception.CategoriaNaoEcontradaException;
import com.example.Eccomerce.Model.Categoria;
import com.example.Eccomerce.Service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaS;

	@GetMapping()
	public List<CategoriaDTO> listsAll() {
		List<Categoria> list = categoriaS.listarTudo();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}

	@GetMapping("{id}")
	public Categoria getOne(@PathVariable Integer id) throws CategoriaNaoEcontradaException {
		return categoriaS.listarCategoria(id);
	}

	@PutMapping("/{id}")
	public CategoriaDTO update(@RequestBody CategoriaDTO categoria, @PathVariable Integer id)
			throws CategoriaNaoEcontradaException, CategoriaExisteException {
		categoriaS.editarCategoria(categoriaS.TransformaCategoriaDto(categoria), id);
		return categoria;
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody CategoriaDTO categoria) throws CategoriaExisteException {
		// Transformação de DTO para Categoria no Service.
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws CategoriaNaoEcontradaException {
		categoriaS.deletarCategoria(id);
	}

}
