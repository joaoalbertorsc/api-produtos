package com.api.produtos.service;

import com.api.produtos.dto.ProdutoRequestDTO;
import com.api.produtos.dto.ProdutoUpdateDTO;
import com.api.produtos.exception.ProdutoJaExisteException;
import com.api.produtos.exception.ProdutoNotFoundException;
import com.api.produtos.model.Produto;
import com.api.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    public Produto criar(ProdutoRequestDTO dto) {
        if (repository.findByNomeIgnoreCase(dto.nome()).isPresent()) {
            throw new ProdutoJaExisteException(dto.nome());
        }
        Produto produto = new Produto(dto.nome(), dto.preco());
        return repository.save(produto);
    }

    public Produto atualizar(Integer id, ProdutoUpdateDTO dto) {
        Produto existente = buscarPorId(id);

        if (dto.nome() != null && !dto.nome().isBlank()) {
            existente.setNome(dto.nome());
        }
        if (dto.preco() != null) {
            existente.setPreco(dto.preco());
        }

        return repository.save(existente);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
