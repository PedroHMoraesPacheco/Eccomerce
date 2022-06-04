package com.example.Eccomerce.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.CategoriaDTO;
import com.example.Eccomerce.Exception.CategoriaExisteException;
import com.example.Eccomerce.Exception.CategoriaNaoEcontradaException;
import com.example.Eccomerce.Model.Categoria;
import com.example.Eccomerce.Repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaR;

	public Categoria TransformaCategoriaDto(CategoriaDTO categoriaDto) {
		Categoria novaCategoria = new Categoria();
		novaCategoria.setNome(categoriaDto.getNome());
		novaCategoria.setDescricao(categoriaDto.getDescricao());
		novaCategoria.setNumeroCategoria(categoriaDto.getNumeroCategoria());
		categoriaR.save(novaCategoria);
		return novaCategoria;
	}

	public List<Categoria> listarTudo() {
		return categoriaR.findAll();
	}

	// get
	public Categoria listarCategoria(Integer id) throws CategoriaNaoEcontradaException {
		Optional<Categoria> optional = categoriaR.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaNaoEcontradaException("A Categoria não foi encontrada!");
		}
		return optional.get();
	}

	public void verificarCategoriaExiste(Categoria categoria) throws CategoriaExisteException {
		Optional<Categoria> optional = categoriaR.findById(categoria.getId());
		if (optional.isPresent()) {
			throw new CategoriaExisteException("Categoria já cadastrada!");
		}
	}

	// post
	public void criarCategoria(Categoria categoria) throws CategoriaExisteException {
		verificarCategoriaExiste(categoria);
		categoriaR.save(categoria);
	}

	// put
	@SuppressWarnings("unlikely-arg-type")
	public Categoria editarCategoria(Categoria categoria, Integer id)
			throws CategoriaExisteException, CategoriaNaoEcontradaException {
		Optional<Categoria> optional = categoriaR.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaNaoEcontradaException("A Categoria não foi encontrada!");
		}
		Categoria categoriaOld = optional.get();
		if (!categoria.getNome().equals("") && categoria.getNome() != null) {
			verificarCategoriaExiste(categoria);
			categoriaOld.setNome(categoria.getNome());
		}
		if (!categoria.getNumeroCategoria().equals("") && categoria.getNumeroCategoria() != null) {
			verificarCategoriaExiste(categoria);
			categoriaOld.setNumeroCategoria(categoria.getNumeroCategoria());
		}
		if (!categoria.getDescricao().equals("") && categoria.getDescricao() != null) {
			verificarCategoriaExiste(categoria);
			categoriaOld.setDescricao(categoria.getDescricao());
		}
		return categoriaR.save(categoria);
	}

	// delete
	public void deletarCategoria(Integer id) throws CategoriaNaoEcontradaException {
		Optional<Categoria> optional = categoriaR.findById(id);

		if (optional.isEmpty()) {
			throw new CategoriaNaoEcontradaException("A Categoria não foi encontrada!");
		}
		categoriaR.deleteById(id);
	}
}
