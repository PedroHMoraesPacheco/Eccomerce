package com.example.Eccomerce.Controller;

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

import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Model.ClienteDTO;
import com.example.Eccomerce.Service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
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
}
