package com.rremiao.produtoservice.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rremiao.produtoservice.business.dto.ProdutoDTO;

@Repository
public interface IProdutoRepository {
    public List<ProdutoDTO> listaProdutos();

    public boolean podeVender(Integer codigo, Integer quantidade);

    ProdutoDTO buscaProduto(Integer codigo);
}
