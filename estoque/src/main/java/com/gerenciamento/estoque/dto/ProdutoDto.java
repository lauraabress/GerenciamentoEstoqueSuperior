package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProdutoDto(

        @NotBlank(message = "Não é possível salvar um produto sem um nome")
        String nmProduto,

        @NotBlank(message = "O produto precisa de uma descrição")
        String dsProduto,

        @Pattern(regexp = "^S|N$", message = "Só é possível salvar o produto com 'S' ou 'N' para indicar o status")
        String flAtivo
) {
}
