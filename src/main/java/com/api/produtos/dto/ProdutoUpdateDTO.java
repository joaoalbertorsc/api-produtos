package com.api.produtos.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProdutoUpdateDTO(
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nome,

        @Positive(message = "Preço deve ser maior que zero")
        Double preco
) {
}