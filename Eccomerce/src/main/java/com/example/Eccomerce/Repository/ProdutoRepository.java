package com.example.Eccomerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Eccomerce.Model.Produto;


public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

	Optional<Produto> findByName(String nome);
}
