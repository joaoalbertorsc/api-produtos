package com.api.produtos.repository;

import com.api.produtos.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProdutoRepository {

    private final Map<Integer, Produto> storage = new LinkedHashMap<>();
    private final AtomicInteger idSequence = new AtomicInteger(1);

    public List<Produto> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Produto> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public boolean existsByNome(String nome) {
        return storage.values().stream()
                .anyMatch(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public Produto save(Produto produto) {
        produto.setId(idSequence.getAndIncrement());
        storage.put(produto.getId(), produto);
        return produto;
    }

    public Produto update(Produto produto) {
        storage.put(produto.getId(), produto);
        return produto;
    }

    public void deleteById(Integer id) {
        storage.remove(id);
    }
}