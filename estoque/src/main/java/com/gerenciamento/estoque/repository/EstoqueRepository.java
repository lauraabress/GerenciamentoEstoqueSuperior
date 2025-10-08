package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EstoqueModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
    Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque);
    
    @Query("SELECT est FROM EstoqueModel est WHERE est.flAtivo = 'S'")
    List<EstoqueModel> findAllByFlAtivo();
    
    @Transactional
    Optional<EstoqueModel> deleteByCdEstoque(Integer cdEstoque);
    
}
