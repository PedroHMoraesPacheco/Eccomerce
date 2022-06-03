package com.example.Eccomerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Eccomerce.Model.Imagem;
import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Repository.ImagemRepository;

@Service
public class ImagemService {
	@Autowired 
	private ImagemRepository imagemRepository;
	
	public Imagem inserir(Produto produto, MultipartFile file) {
		Imagem imagem = new Imagem();
		imagem.setImagem(file.getBytes());
		imagem.setNome(produto);
		return imageRepository.save(imagem);
	}
	
	
	
	

}
