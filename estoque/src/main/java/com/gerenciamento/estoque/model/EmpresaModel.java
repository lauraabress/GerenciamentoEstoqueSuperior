package com.gerenciamento.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// NÃO PRECISAMOS CRIAR OS CONTRUTORES DENTRO DA CLASSE
@AllArgsConstructor

// NÃO PRECISE DOS ARGUMENTOS
@NoArgsConstructor

// CRIA NOSSOS GETTERS E SETTERS
@Data

// TRANSFORMA A MINHA CLASSE EM ENTIDADE - VIRA UMA TABELA NO BANCO DE DADOS
@Entity

// PERMITE FAZER MODIFICAÇÕES NA NOSSA TABELA
@Table (name = "TBEMPRESA")
public class EmpresaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDEMPRESA")
    private Integer cdEmpresa;

    @Column(name = "NMRAZAO", length = 100, nullable = false)
    private String nmRazao;

    @Column(name = "NMFANTASIA", length = 100)
    private String nmFantasia;

    @Column(name = "NUCNPJ", length = 20, nullable = false, unique = true)
    private String nuCnpj;

    @Column(name = "NUTELEFONE", length = 14)
    private String nuTelefone;

    @Column(name = "DSENDERECO", length = 100)
    private String dsEndereco;

    @Column(name = "NUENDERECO")
    private Integer nuEndereco;

    @Column(name = "FLATIVO", length = 1, nullable = false      )
    private String flAtivo;

}
