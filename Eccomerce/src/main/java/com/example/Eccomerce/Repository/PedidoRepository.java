package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.DTO.PedidoDTO;

@Repository
public interface PedidoRepository extends  JpaRepository <PedidoDTO, Integer> {

}
