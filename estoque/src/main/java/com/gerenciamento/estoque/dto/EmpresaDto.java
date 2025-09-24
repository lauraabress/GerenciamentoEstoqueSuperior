package com.gerenciamento.estoque.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmpresaDto(

        @NotBlank(message = "A razão social não pode ser null")
        String nmRazao,
        String nmFantasia,

        @NotBlank(message = "O número do CNPJ não pode ser null")
        String nuCnpj,

        @NotBlank(message = "O número de telefone não pode ser null")
        String nuTelefone,

        @NotBlank(message = "Não é possível salvar a empresa sem um endereço")
        String dsEndereco,
        Integer nuEndereco,

        @Pattern(regexp = "^S|N$", message = "Só é possível salvar a empresa com 'S' ou 'N' para indicar o status")
        String flAtivo
) {
}
