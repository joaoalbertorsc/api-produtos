package com.api.produtos.exception;

public class ProdutoJaExisteException extends RuntimeException {
    public ProdutoJaExisteException(String nome) {
        super("Já existe um produto com o nome: " + nome);
    }
}