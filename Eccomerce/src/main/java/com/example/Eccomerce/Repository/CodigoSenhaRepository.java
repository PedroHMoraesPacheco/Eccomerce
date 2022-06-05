package com.example.Eccomerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.CodigoSenha;

@Repository
public interface CodigoSenhaRepository extends JpaRepository <CodigoSenha, String>{
	
	Optional<CodigoSenha> findByCodigo(String codigo);

}
