package com.example.Eccomerce.Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.DTO.EnderecoDTO;
import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Service.ClienteService;
import com.example.Eccomerce.Service.EnderecoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EnderecoService enderecoService;
	
		@GetMapping
		public List<ClienteDTO> getTodos(){
			List<Cliente> list=clienteService.RetorneTodos();
			List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
			return listDTO;
		}
		
		@GetMapping("/{id}")
		public ClienteDTO findByid(@PathVariable Integer id){
			ClienteDTO novaDTO = new ClienteDTO(clienteService.findClienteByid(id));
			return novaDTO;
		}
		
		@PostMapping("/{id}")
		public ClienteDTO newCliente(@RequestBody Cliente novaCliente){ 
			clienteService.newCliente(novaCliente);
			ClienteDTO novaDTO = new ClienteDTO(novaCliente);
			return novaDTO;
		}
		
		@DeleteMapping("/{id}")
		public void deleteById(@PathVariable Integer id){
			clienteService.deleteById(id);
		}
		
		@PutMapping("/{id}")
		public ClienteDTO changeById(@PathVariable Integer id, @RequestBody Cliente novaCliente){
			clienteService.changeById(id, novaCliente);
			ClienteDTO novaDTO = new ClienteDTO(novaCliente);
			return novaDTO;
		}
		@PostMapping("/{cep}")
		public EnderecoDTO newEndereco(@PathVariable String cep, @PathVariable Integer id ) throws IOException{ 
			EnderecoDTO novaDTO = new EnderecoDTO(enderecoService.getEnderecoByCep(cep, id));
			return novaDTO;
		}
}
