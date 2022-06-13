package com.rremiao.produtoservice.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rremiao.produtoservice.business.dto.ProdutoDTO;
import com.rremiao.produtoservice.business.entity.Produto;
import com.rremiao.produtoservice.core.operation.ProdutoOperationRepository;

@Repository
public class ProdutoRepository {

    @Autowired
    ProdutoOperationRepository operationRepository;

    public List<ProdutoDTO> listaProdutos() {
        Iterable<Produto> produtos = operationRepository.findAll();

        List<ProdutoDTO> response = new ArrayList<ProdutoDTO>();

        for(Produto prod : produtos) {
            ProdutoDTO produto = new ProdutoDTO();

            produto.withCodigo(prod.getCodigo())
                   .withDescricao(prod.getDescricao())
                   .withPreco(prod.getPreco())
                   .withQuantidade(prod.getQtdade())
                   .withUrlImagem(prod.getUrlImagem())
                   .withSituacao(prod.getSituacao());

            response.add(produto);
        }
        return response;
    }

    public boolean podeVender(Integer codigo, Integer quantidade) {
        List<ProdutoDTO> produtos = new ArrayList<>();

        final boolean disponivel = produtos.stream().anyMatch(p -> p.getCodigo() == codigo 
                                    && p.getSituacao().equals("A"));
        return disponivel;
    }

    public ProdutoDTO buscaProduto(Integer codigo) {
        Optional<Produto> prod = operationRepository.findById(codigo);
        Produto produto = prod.get();

        ProdutoDTO response = new ProdutoDTO();

        response.withCodigo(produto.getCodigo())
                .withDescricao(produto.getDescricao())
                .withPreco(produto.getPreco())
                .withQuantidade(produto.getQtdade())
                .withSituacao(produto.getSituacao())
                .withUrlImagem(produto.getUrlImagem());

        return response;
    }
}
