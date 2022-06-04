package com.example.Eccomerce.Service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Eccomerce.Model.Imagem;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired 
	ImagemRepository repository;
	
	@Transactional
	public Imagem create(Produto produto, MultipartFile file) throws IOException {
		Imagem imagem = new Imagem();
		imagem.setMimetype(file.getContentType());
		imagem.setNome(file.getName());
		imagem.setData(file.getBytes());
		imagem.setProduto(produto);
		return repository.save(imagem);
	}
}