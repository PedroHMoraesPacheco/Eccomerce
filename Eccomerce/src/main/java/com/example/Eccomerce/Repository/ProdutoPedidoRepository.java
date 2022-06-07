package com.example.Eccomerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Produtos_Pedidos;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<Produtos_Pedidos, Integer>{

	Optional<Produtos_Pedidos> findByProdutoIdAndPedidoId(Integer id, Integer id2);

}
