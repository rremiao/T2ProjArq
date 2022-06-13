package com.rremiao.produtoservice.business.interfaces;

import java.util.List;

import com.rremiao.produtoservice.business.dto.ProdutoDTO;

public interface ICalculaImposto {
    public double calculaImpostoSimples(List<ProdutoDTO> produto);

    public double calculaImpostoComposto(List<ProdutoDTO> produto);

    public int calculaImpostoSubtotal(double subtotal);
}
