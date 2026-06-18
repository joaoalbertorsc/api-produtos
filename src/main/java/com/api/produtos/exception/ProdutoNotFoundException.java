package com.api.produtos.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Integer id) {
        super("Produto não encontrado com id: " + id);
    }
}