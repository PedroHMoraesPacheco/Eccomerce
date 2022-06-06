package com.example.Eccomerce.Service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Eccomerce.Model.Imagem;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired 
	ImagemRepository repository;
	
	public List<Imagem> RetorneTodos(){
		return repository.findAll();
	}
	public Imagem findImagemByid(Long id){
		return repository.findById(id).get();
	}
	
	public void deleteById(Long id){
		 repository.deleteById(id);
	}
	
	@Transactional
	public Imagem create(Produto produto, MultipartFile file) throws IOException {
		Imagem imagem = new Imagem();
		imagem.setMimetype(file.getContentType());
		imagem.setNome(file.getName());
		imagem.setData(file.getBytes());
		imagem.setProduto(produto);
		return repository.save(imagem);
	}
	
	public String createUrl(Integer id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/image").buildAndExpand(id)
				.toUri();
		return uri.toString();
	}
	@Transactional
	public Imagem getImage(Long id) {
		Optional<Imagem> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
}