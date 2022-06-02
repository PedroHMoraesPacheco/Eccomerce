package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Eccomerce.Model.Pedido;


public interface PedidoRepository extends  JpaRepository <Pedido, Integer> {

}
