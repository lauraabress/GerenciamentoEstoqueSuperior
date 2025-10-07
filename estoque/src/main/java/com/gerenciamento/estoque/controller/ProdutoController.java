package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.repository.ProdutoRepository;
import com.gerenciamento.estoque.service.EmpresaService;
import com.gerenciamento.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criar (@Valid @RequestBody ProdutoDto dto){
        ProdutoModel produtoModel = produtoService.salvar(dto);
        return ResponseEntity.ok(produtoModel);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarTodos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<ProdutoModel>> listarAtivos(){
        return ResponseEntity.ok(produtoService.listarProdutosAtivas());
    }

    @GetMapping("/{cdProduto}")
    public ResponseEntity<ProdutoModel> listarPorCdProduto (@PathVariable Integer cdProduto){
        return produtoService.findByCdProduto(cdProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
