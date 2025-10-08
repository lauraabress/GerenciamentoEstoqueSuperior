package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

    public EstoqueModel salvar(EstoqueDto dto){
        EstoqueModel estoque = new EstoqueModel();
        estoque.setCdLocalEstoque(dto.cdLocalEstoque());
        estoque.setQtEstoque(dto.qtEstoque());
        estoque.setFlAtivo(dto.flAtivo());
        return estoqueRepository.save(estoque);
    }

    public List<EstoqueModel> listarTodos(){
        return estoqueRepository.findAll();
    }

    public List<EstoqueModel> listarEmpresasAtivas(){
        return estoqueRepository.findAllByFlAtivo();
    }

    public Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque){
        return estoqueRepository.findByCdEstoque(cdEstoque);
    }

    public Optional<EstoqueModel> atualizaDados(Integer cdEstoque, EstoqueDto estoqueDto){
        return estoqueRepository.findByCdEstoque(cdEstoque).map(estoque -> {
            estoque.setCdLocalEstoque(estoqueDto.cdLocalEstoque());
            estoque.setQtEstoque(estoqueDto.qtEstoque());
            estoque.setFlAtivo(estoqueDto.flAtivo());
            return estoqueRepository.save(estoque);
        });
    }


}
