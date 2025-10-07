package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.model.ProdutoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    Optional<ProdutoModel> findByCdProduto(Integer cdProduto);

    @Query("SELECT prod FROM ProdutoModel prod WHERE prod.flAtivo = 'S'")
    List<ProdutoModel> findByFlAtivo();

    @Transactional
    Optional<EmpresaModel> deleteByCdProduto(Integer cdProduto);

}
