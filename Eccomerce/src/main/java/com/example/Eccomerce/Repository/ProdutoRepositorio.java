package com.example.Eccomerce.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Eccomerce.Model.Produto;


public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
	
}
