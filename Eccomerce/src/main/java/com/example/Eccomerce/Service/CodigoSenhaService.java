package com.example.Eccomerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.CodigoSenha;
import com.example.Eccomerce.Repository.CodigoSenhaRepository;

@Service
public class CodigoSenhaService {

	@Autowired
	CodigoSenhaRepository codeRepo;
	
	public CodigoSenha userByCodigo(String codigo) {
		return codeRepo.findByCodigo(codigo).get();
	}
}
