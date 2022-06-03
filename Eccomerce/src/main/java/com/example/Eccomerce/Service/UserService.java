package com.example.Eccomerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.ClienteDTO;
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
}
