package com.example.Eccomerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

	Optional<Produto> findByNome(String nome);
}
