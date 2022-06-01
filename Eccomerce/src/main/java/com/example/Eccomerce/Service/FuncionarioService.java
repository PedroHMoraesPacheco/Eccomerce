package com.example.Eccomerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.Funcionario;
import com.example.Eccomerce.Repository.RepositoryFuncionario;

@Service
public class FuncionarioService {
	
	@Autowired
	RepositoryFuncionario repositorio;
	
	public List<Funcionario> retorneTODOS() {
		return repositorio.findAll();
	}
	
	public Funcionario funcionarioByID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void Delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void Post(Funcionario funcionario) {
		repositorio.save(funcionario);
	}
	
	public Funcionario changeById(Integer id, Funcionario novaFuncionario){
		Funcionario FuncionarioVelho=repositorio.findById(id).get();
            if (novaFuncionario.getNome() != null) {
            	FuncionarioVelho.setNome(novaFuncionario.getNome());
           }
           if (novaFuncionario.getFuncionario().getEmail() != null  ) {
        	   FuncionarioVelho.getFuncionario().setEmail(novaFuncionario.getFuncionario().getEmail());
           }
           if (novaFuncionario.getDataDeNascimento() != null) {
        	   FuncionarioVelho.setDataDeNascimento(novaFuncionario.getDataDeNascimento());
           }
           if (novaFuncionario.getTelefone() != null) {
        	   FuncionarioVelho.setTelefone(novaFuncionario.getTelefone());
           }
           if (novaFuncionario.getFuncionario().getUsername() != null) {
        	   FuncionarioVelho.getFuncionario().setUsername(novaFuncionario.getFuncionario().getUsername());
           }
           return repositorio.save(FuncionarioVelho);
   }
}

