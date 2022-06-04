package com.example.Eccomerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.DTO.FuncionarioDTO;
import com.example.Eccomerce.Model.Funcionario;
import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository repositorio;
	
	@Autowired
	UserService userService;
	
	public List<Funcionario> retorneTODOS() {
		return repositorio.findAll();
	}
	
	public Funcionario funcionarioByID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void Delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void newFuncionario(Funcionario funcionario) {
		repositorio.save(funcionario);
	}
	
	public Funcionario changeById(Integer id, Funcionario novaFuncionario){
		Funcionario FuncionarioVelho=repositorio.findById(id).get();
            if (novaFuncionario.getNome() != null) {
            	FuncionarioVelho.setNome(novaFuncionario.getNome());
           }
           if (novaFuncionario.getFuncionario().getEmail() != null  ) {
        	   FuncionarioVelho.getFuncionario().setEmail(novaFuncionario.getFuncionario().getEmail());
           }
           if (novaFuncionario.getDataDeNascimento() != null) {
        	   FuncionarioVelho.setDataDeNascimento(novaFuncionario.getDataDeNascimento());
           }
           if (novaFuncionario.getTelefone() != null) {
        	   FuncionarioVelho.setTelefone(novaFuncionario.getTelefone());
           }
           if (novaFuncionario.getFuncionario().getUsername() != null) {
        	   FuncionarioVelho.getFuncionario().setUsername(novaFuncionario.getFuncionario().getUsername());
           }
           return repositorio.save(FuncionarioVelho);
    }
	
	public Funcionario TransformaDto(FuncionarioDTO velhoDto, User usuario) {
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setFuncionario(usuario);
        novoFuncionario.setNome(velhoDto.getNome());
        novoFuncionario.setTelefone(velhoDto.getTelefone());
        novoFuncionario.setCpf(velhoDto.getCpf());
        novoFuncionario.setDataDeNascimento(velhoDto.getData());
        novoFuncionario.getFuncionario().setEmail(velhoDto.getEmail());
        novoFuncionario.getFuncionario().setSenha(velhoDto.getSenha());
        novoFuncionario.getFuncionario().setUsername(velhoDto.getUsername());
        novoFuncionario.getFuncionario().setRole(velhoDto.getRole());

        repositorio.save(novoFuncionario);
        return novoFuncionario;
    }
	
	public Funcionario PutByDTO(Integer id,FuncionarioDTO novoFuncionario) {
        Funcionario velhoFuncionario=funcionarioByID(id);
        if(novoFuncionario.getNome()!=null) {
            velhoFuncionario.setNome(novoFuncionario.getNome());
        }
        if(novoFuncionario.getTelefone()!=null) {
            velhoFuncionario.setTelefone(novoFuncionario.getTelefone());
        }
        if(novoFuncionario.getCpf()!=null) {
            velhoFuncionario.setCpf(novoFuncionario.getCpf());
        }
        if(novoFuncionario.getData()!=null) {
            velhoFuncionario.setDataDeNascimento(novoFuncionario.getData());
        }
        if(novoFuncionario.getEmail()!=null) {
            velhoFuncionario.getFuncionario().setEmail(novoFuncionario.getEmail());
        }
        if(novoFuncionario.getUsername()!=null) {
            velhoFuncionario.getFuncionario().setUsername(novoFuncionario.getUsername());
        }
        if(novoFuncionario.getSenha()!=null) {
            velhoFuncionario.getFuncionario().setSenha(novoFuncionario.getSenha());
        }
        repositorio.save(velhoFuncionario);
        return velhoFuncionario;
    }
	
	public User PutUserFuncionarioDto(FuncionarioDTO funcionarioDto) {
        return userService.TransformaUserFuncionarioDto(funcionarioDto);
    }
	
}

