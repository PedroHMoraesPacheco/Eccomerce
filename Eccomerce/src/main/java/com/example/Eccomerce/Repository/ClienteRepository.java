package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
