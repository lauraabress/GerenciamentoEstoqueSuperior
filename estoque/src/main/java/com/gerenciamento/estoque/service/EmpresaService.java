package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ARMAZENA AS REGRAS DE NEGOCIOS EX: TODA VEZ Q FAZ PEDIDO GANHA 10% DE DESCONTO
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaModel salvar(EmpresaDto dto) {
        EmpresaModel empresa = new EmpresaModel();
        empresa.setNmFantasia(dto.nmFantasia());
        empresa.setNmRazao(dto.nmRazao());
        empresa.setNuCnpj(dto.nuCnpj());
        empresa.setFlAtivo(dto.flAtivo());
        empresa.setDsEndereco(dto.dsEndereco());
        empresa.setNuEndereco(dto.nuEndereco());
        return empresaRepository.save(empresa);
    }

    public List<EmpresaModel> listarTodos() {
        return empresaRepository.findAll();
    }

    public List<EmpresaModel> listarEmpresasAtivas() {
        return empresaRepository.findAllByFlAtivo();
    }

    public Optional<EmpresaModel> findByCdEmpresa(Integer cdEmpresa) {
        return empresaRepository.findByCdEmpresa(cdEmpresa);
    }

    public Optional<EmpresaModel> findByNuCnpj(String nuCnpj) {
        return empresaRepository.findByNuCnpj(nuCnpj);
    }

    public Optional<EmpresaModel> atualizaDados(Integer cdEmpresa, EmpresaDto empresaDto) {
        return empresaRepository.findByCdEmpresa(cdEmpresa).map(empresa -> {
            empresa.setNuCnpj(empresaDto.nuCnpj());
            empresa.setNuEndereco(empresaDto.nuEndereco());
            empresa.setNmFantasia(empresaDto.nmFantasia());
            empresa.setNmRazao(empresaDto.nmRazao());
            empresa.setDsEndereco(empresaDto.dsEndereco());
            empresa.setNuTelefone(empresaDto.nuTelefone());
            empresa.setFlAtivo(empresaDto.flAtivo());
            return empresaRepository.save(empresa);
        });
    }

    public void deletarEmpresa(Integer cdEmpresa){
        empresaRepository.deleteByCdEmpresa(cdEmpresa);
    }

}
