package com.rremiao.produtoservice.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rremiao.produtoservice.business.dto.ProdutoDTO;
import com.rremiao.produtoservice.core.implementation.CalculaImpostoImpl;
import com.rremiao.produtoservice.core.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private CalculaImpostoImpl calculaImposto;

    public List<ProdutoDTO> listaProdutos() {
        return produtoRepository.listaProdutos();
    }

    public boolean podeVender(Integer codigo, Integer quantidade) {
        return produtoRepository.podeVender(codigo, quantidade);
    }

    public ProdutoDTO buscaProduto(Integer codigo) {
        return produtoRepository.buscaProduto(codigo);
    }

    public double calculaImpostoSimples(List<ProdutoDTO> produtos) {
        return calculaImposto.calculaImpostoSimples(produtos);
    }
}
