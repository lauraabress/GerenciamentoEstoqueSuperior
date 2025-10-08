package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EstoqueDto(

        @NotNull(message = "O código do local do estoque não pode ser mull")
        Integer cdLocalEstoque,

        @NotNull(message = "O estoque não pode ser mill")
        Integer qtEstoque,

        @Pattern(regexp = "^S|N$", message = "O flAtivo deve ser 'S' ou 'N'")
        String flAtivo

) {
}
