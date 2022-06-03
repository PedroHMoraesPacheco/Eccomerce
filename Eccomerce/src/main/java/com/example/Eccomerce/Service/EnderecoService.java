package com.example.Eccomerce.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.Endereco;
import com.example.Eccomerce.Repository.EnderecoRepository;
import com.google.gson.Gson;

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
		
		//VIACEP
		URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
		URLConnection connection = url.openConnection();
		InputStream is =connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		String viacep="";
		StringBuilder jsonCep=new StringBuilder();
		
		while((viacep= br.readLine())!=null) {
			jsonCep.append(viacep);
		}
		//
		
		Endereco enderecoAux= new Gson().fromJson(jsonCep.toString(), Endereco.class);
		
		novoEndereco.setCep(enderecoAux.getCep());
		novoEndereco.setLogradouro(enderecoAux.getLogradouro());
		novoEndereco.setBairro(enderecoAux.getBairro());
		novoEndereco.setCidade(enderecoAux.getCidade());
		novoEndereco.setNumero(enderecoAux.getNumero());
		novoEndereco.setComplemento(enderecoAux.getComplemento());
		novoEndereco.setEstado(enderecoAux.getEstado());
		enderecoRepo.save(novoEndereco);
		return novoEndereco;
	}
}
