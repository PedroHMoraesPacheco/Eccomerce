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

import com.example.Eccomerce.DTO.EnderecoDTO;
import com.example.Eccomerce.Model.Endereco;
import com.example.Eccomerce.Service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public List<EnderecoDTO> getTodos(){
		List<Endereco> list=enderecoService.listarTudo();
		List<EnderecoDTO> listDTO = list.stream().map(obj -> new EnderecoDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}
	
	@GetMapping("/{id}")
	public EnderecoDTO findByid(@PathVariable Integer id){
		EnderecoDTO novaDTO = new EnderecoDTO(enderecoService.findEnderecoById(id));
		return novaDTO;
	}
	
	@PostMapping("/{cep}/{id}")
	public EnderecoDTO newEndereco(@PathVariable String cep,@PathVariable Integer id ) throws IOException{ 
		EnderecoDTO novaDTO = new EnderecoDTO(enderecoService.getEnderecoByCep(cep,id));
		return novaDTO;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id){
		enderecoService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public EnderecoDTO changeById(@PathVariable Integer id, @RequestBody Endereco novaEndereco){
		enderecoService.changeById(id, novaEndereco);
		EnderecoDTO novaDTO = new EnderecoDTO(novaEndereco);
		return novaDTO;
	}
}
