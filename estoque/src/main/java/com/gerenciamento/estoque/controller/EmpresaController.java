package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//PERMITE A GENTE CONFIGURAR O LOG - DEIXA A MENSAGEM MAIS EXPLICIDA CASO DE ERRO
@Slf4j
@RestController
@RequestMapping("api/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;
    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaModel> criar (@Valid @RequestBody EmpresaDto dto){
        EmpresaModel empresaModel = empresaService.salvar(dto);
        return ResponseEntity.ok(empresaModel);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listarTodas(){
        return ResponseEntity.ok(empresaService.listarTodos());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<EmpresaModel>> listarAtivas(){
        return ResponseEntity.ok(empresaService.listarEmpresasAtivas());
    }

    @GetMapping("/{cdEmpresa}")
    public ResponseEntity<EmpresaModel> listarPorCdEmpresa(@PathVariable Integer cdEmpresa){
        return empresaService.findByCdEmpresa(cdEmpresa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
