package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EmpresaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
    Optional<EmpresaModel> FindByCdEmpresa (Integer cdEmpresa);
    Optional<EmpresaModel> FindByNuCnpj (Integer nuCnpj);

    @Query("SELECT emp FROM EmpresaModel emp WHERE emp.flAtivo = 'S'")
    List<EmpresaModel> findAllByFlAtivo();

    // BEGIN - COMMIT - EXCEPTION - ROLLBACK - END
    @Transactional
    Optional<EmpresaModel> deleteByCdEmpresa(Integer cdEmpresa);


}
