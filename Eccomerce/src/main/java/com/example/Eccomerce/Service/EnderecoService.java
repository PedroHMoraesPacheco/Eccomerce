package com.example.Eccomerce.Service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Eccomerce.Model.Endereco;
import com.example.Eccomerce.Repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepo;
	@Autowired
	ClienteService clienteService;
	public List<Endereco> listarTudo() {
		return enderecoRepo.findAll();
	}
	public Endereco findEnderecoById(Integer id){
		return enderecoRepo.findById(id).get();
	}
	public Endereco newEndereco(Endereco novaEndereco){
		return enderecoRepo.save(novaEndereco);
	}
	public void deleteById(Integer id){
		enderecoRepo.deleteById(id);
	}
	public void changeById(Integer id, Endereco novaEndereco) {
		 	
	}
	
	public Endereco getEnderecoByCep(String cep, Integer id) throws IOException {
		
		Endereco novoEndereco= new Endereco();
		
		String fullUrl = "https://viacep.com.br/ws/"+cep+"/json";
		RestTemplate restTemplate = new RestTemplate();
		Endereco enderecoAux = restTemplate.getForObject(fullUrl, Endereco.class);
		
		System.out.println(enderecoAux);
		novoEndereco.setCep(enderecoAux.getCep());
		novoEndereco.setLogradouro(enderecoAux.getLogradouro());
		novoEndereco.setBairro(enderecoAux.getBairro());
		novoEndereco.setCidade(enderecoAux.getCidade());
		novoEndereco.setEstado(enderecoAux.getEstado());
		
		novoEndereco.setCliente_id(clienteService.findClienteByid(id));
		
		enderecoRepo.save(novoEndereco);
		return novoEndereco;
	}
}
