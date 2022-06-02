package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Eccomerce.PedidoDTO;


public interface PedidoRepository extends  JpaRepository <PedidoDTO, Integer> {

}
