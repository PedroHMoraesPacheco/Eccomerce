package com.example.Eccomerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.DTO.FuncionarioDTO;
import com.example.Eccomerce.Model.CodigoSenha;
import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Repository.CodigoSenhaRepository;

@Service
public class CodigoSenhaService {

	@Autowired
	CodigoSenhaRepository codeRepo;
	public void SalvaCodigo(CodigoSenha codigo) {
		codeRepo.save(codigo);
	}
	public List<CodigoSenha> retorneTODOS() {
		return codeRepo.findAll();
	}
	
	public void DeleteByCodigo(String codigo) {
		codeRepo.deleteByCodigo(codigo);
	}
	public CodigoSenha codigoSenhaByCodigo(String codigo) {
		return codeRepo.findByCodigo(codigo).get();
	}
}
