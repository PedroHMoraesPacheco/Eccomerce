package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
