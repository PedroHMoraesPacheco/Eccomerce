package com.example.Eccomerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.DTO.FuncionarioDTO;
import com.example.Eccomerce.Model.Funcionario;
import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepo;
	
	public User TransformaUserClienteDto(ClienteDTO clienteDto) {
		User novoUser=new User();
		novoUser.setEmail(clienteDto.getEmail());
		novoUser.setRole(clienteDto.getRole());
		novoUser.setSenha(clienteDto.getSenha());
		novoUser.setUsername(clienteDto.getUsername());
		userRepo.save(novoUser);
		return novoUser;
	}
	
	public User TransformaUserFuncionarioDto(FuncionarioDTO funcionarioDto) {
		User novoUser=new User();
		novoUser.setEmail(funcionarioDto.getEmail());
		novoUser.setRole(funcionarioDto.getRole());
		novoUser.setSenha(funcionarioDto.getSenha());
		novoUser.setUsername(funcionarioDto.getUsername());
		userRepo.save(novoUser);
		return novoUser;
	}
	
	public List<User> retorneTODOS() {
		return userRepo.findAll();
	}
	
	public User userByID(Integer id) {
		return userRepo.findById(id).get();
	}
	
	public void Delete(Integer id) {
		userRepo.deleteById(id);
	}
}
