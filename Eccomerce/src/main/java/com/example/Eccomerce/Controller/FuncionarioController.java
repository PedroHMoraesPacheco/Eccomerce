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

import com.example.Eccomerce.DTO.FuncionarioDTO;
import com.example.Eccomerce.Model.Funcionario;
import com.example.Eccomerce.Service.FuncionarioService;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
	
		@Autowired
		FuncionarioService funcionarioService;
		
			@GetMapping
			public List<FuncionarioDTO> getTodos(){
				List<Funcionario> list=funcionarioService.retorneTODOS();
				List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
				return listDTO;
			}
			
			@GetMapping("/{id}")
			public FuncionarioDTO findByid(@PathVariable Integer id){
				FuncionarioDTO novaDTO = new FuncionarioDTO(funcionarioService.funcionarioByID(id));
				return novaDTO;
			}
			
			@PostMapping()
			public FuncionarioDTO newFuncionario(@RequestBody FuncionarioDTO funcionario){ 
				funcionarioService.TransformaDto(funcionario, funcionarioService.PutUserFuncionarioDto(funcionario));
				return funcionario;
			}
			
			@DeleteMapping("/{id}")
			public void deleteById(@PathVariable Integer id){
				funcionarioService.Delete(id);
			}
			
			@PutMapping("/{id}")
	        public FuncionarioDTO changeById(@PathVariable Integer id, @RequestBody FuncionarioDTO novaFuncionario){
	            FuncionarioDTO novaDTO= new FuncionarioDTO(funcionarioService.PutByDTO(id, novaFuncionario));
	            return novaDTO;
	        }
			
			

}
