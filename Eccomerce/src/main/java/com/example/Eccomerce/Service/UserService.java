package com.example.Eccomerce.Service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.ClienteDTO;
import com.example.Eccomerce.DTO.FuncionarioDTO;
import com.example.Eccomerce.Model.Cliente;
import com.example.Eccomerce.Model.CodigoSenha;
import com.example.Eccomerce.Model.Funcionario;
import com.example.Eccomerce.Model.Mail;
import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	CodigoSenhaService codeService;
	
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
	
	public void EnviarCodigoDeSenha(Integer id) {
		User usuario= userByID(id);
		
		Random random= new Random();
		Integer numero = random.nextInt(9999);
		String codigo=String.format("%04d", numero).toString();
		CodigoSenha codigosenha = new CodigoSenha();
		
		codigosenha.setCodigo(codigo);
		
		usuario.getCodigo().add(codigosenha);
		codigosenha.setUsuario(usuario);
		Mail emailNovo= new Mail();
		emailNovo.setAssunto("Troca de Senha.");
		String text="Seu codigo é "+codigo+". Utilize o metodo POST /cliente/{codigo} para mudar sua senha.";
		emailNovo.setTexto(text);
		emailNovo.setPara(usuario.getEmail());
		userRepo.save(usuario);
		codeService.SalvaCodigo(codigosenha);
		mailService.createEmail(emailNovo);
	}
	@Transactional
	public void TestarCodigo(Integer id,String codigoteste,String novaSenha) {
		User usuario= userByID(id);
		CodigoSenha codigoAchado=codeService.codigoSenhaByCodigo(codigoteste);
		List<CodigoSenha> list = usuario.getCodigo();
		if(codigoAchado.getUsuario()==usuario) {
			usuario.setSenha(novaSenha);
			codeService.DeleteByCodigo(codigoAchado.getCodigo());
			usuario.setCodigo(null);
			userRepo.save(usuario);
		}else {
			System.out.println("CODIGO INCORRETO");
		}
	}
}
