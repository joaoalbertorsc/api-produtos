package com.api.produtos.service;

import com.api.produtos.dto.ProdutoRequestDTO;
import com.api.produtos.dto.ProdutoUpdateDTO;
import com.api.produtos.exception.ProdutoJaExisteException;
import com.api.produtos.exception.ProdutoNotFoundException;
import com.api.produtos.model.Produto;
import org.springframework.stereotype.Service;
import com.api.produtos.repository.ProdutoRepository;

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
        if (repository.existsByNome(dto.nome())) {
            throw new ProdutoJaExisteException(dto.nome());
        }
        return repository.save(new Produto(null, dto.nome(), dto.preco()));
    }

    public Produto atualizar(Integer id, ProdutoUpdateDTO dto) {
        Produto existente = buscarPorId(id);

        if (dto.nome() != null) existente.setNome(dto.nome());
        if (dto.preco() != null) existente.setPreco(dto.preco());

        return repository.update(existente);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}