package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Pedido;

@Repository
public interface PedidoRepository extends  JpaRepository <Pedido, Integer> {

}
