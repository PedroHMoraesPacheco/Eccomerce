package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository <Imagem, Integer> {

}
