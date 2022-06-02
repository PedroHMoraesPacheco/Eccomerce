package com.example.Eccomerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;

	public List<Cliente> RetorneTodos(){
		return clienteRepo.findAll();
	}
	public Cliente findClienteByid(Integer id){
		return clienteRepo.findById(id).get();
	}
	public Cliente newCliente(Cliente novaCliente){
		return clienteRepo.save(novaCliente);
	}
	public void deleteById(Integer id){
		 clienteRepo.deleteById(id);
	}
	public Cliente changeById(Integer id, Cliente novaCliente){
		 Cliente ClienteVelho=clienteRepo.findById(id).get();
		 	if (novaCliente.getNome() != null) {
				ClienteVelho.setNome(novaCliente.getNome());
			}
			if (novaCliente.getCliente().getEmail() != null  ) {
				ClienteVelho.getCliente().setEmail(novaCliente.getCliente().getEmail());
			}
			if (novaCliente.getDataDeNascimento() != null) {
				ClienteVelho.setDataDeNascimento(novaCliente.getDataDeNascimento());
			}
			if (novaCliente.getTelefone() != null) {
				ClienteVelho.setTelefone(novaCliente.getTelefone());
			}
			if (novaCliente.getCliente().getUsername() != null) {
				ClienteVelho.getCliente().setUsername(novaCliente.getCliente().getUsername());
			}
			return clienteRepo.save(ClienteVelho);
	}
}
