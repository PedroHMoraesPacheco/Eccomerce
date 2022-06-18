package com.example.Eccomerce.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.Exception.PedidoNaoEcontradoException;
import com.example.Eccomerce.Exception.ProdutoNotExcepetion;
import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Model.Mail;
import com.example.Eccomerce.Model.Pedido;
import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
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
		 userService.Delete(findClienteByid(id).getCliente().getId());
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
	
	public Cliente TransformaDto(ClienteDTO velhoDto, User usuario) {
		Cliente novoCliente = new Cliente();
		novoCliente.setCliente(usuario);
		novoCliente.setNome(velhoDto.getNome());
		novoCliente.setTelefone(velhoDto.getTelefone());
		novoCliente.setCpf(velhoDto.getCpf());
		novoCliente.setDataDeNascimento(velhoDto.getData());
		
		clienteRepo.save(novoCliente);
		EmailNovoCliente(novoCliente);
		return novoCliente;
	}
	public Cliente PutByDTO(Integer id,ClienteDTO novoCliente) {
		Cliente velhoCliente=findClienteByid(id);
		if(novoCliente.getNome()!=null) {
			velhoCliente.setNome(novoCliente.getNome());
		}
		if(novoCliente.getTelefone()!=null) {
			velhoCliente.setTelefone(novoCliente.getTelefone());
		}
		if(novoCliente.getCpf()!=null) {
			velhoCliente.setCpf(novoCliente.getCpf());
		}
		if(novoCliente.getData()!=null) {
			velhoCliente.setDataDeNascimento(novoCliente.getData());
		}
		if(novoCliente.getEmail()!=null) {
			velhoCliente.getCliente().setEmail(novoCliente.getEmail());
		}
		if(novoCliente.getUsername()!=null) {
			velhoCliente.getCliente().setUsername(novoCliente.getUsername());
		}
		if(novoCliente.getSenha()!=null) {
			velhoCliente.getCliente().setSenha(novoCliente.getSenha());
		}
		clienteRepo.save(velhoCliente);
		return velhoCliente;
	}

	public User PutUserClienteDto(ClienteDTO clienteDto) {
		return userService.TransformaUserClienteDto(clienteDto);
	}
	
	public void EmailNovoCliente(Cliente cliente) {
		Mail emailNovo= new Mail();
		emailNovo.setAssunto("Nova Conta.");
		String text="Parabens pela criação de uma nova conta!";
		emailNovo.setTexto(text);
		emailNovo.setPara(cliente.getCliente().getEmail());
		mailService.createEmail(emailNovo);
	}
	public void EnviarCodigoDeSenha(Integer id) {
		userService.EnviarCodigoDeSenha(findClienteByid(id).getCliente().getId());
	}
	public void TestarCodigo(Integer id,String codigoteste,String novaSenha) {
		userService.TestarCodigo(findClienteByid(id).getCliente().getId(), codigoteste, novaSenha);
	}
}