package com.rremiao.vendaService.core.implementation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rremiao.vendaService.business.dto.ProdutoDTO;
import com.rremiao.vendaService.business.interfaces.ICalculaImposto;

@Component
public class CalculaImpostoImpl implements ICalculaImposto{

    public double calculaImpostoSimples(List<ProdutoDTO> produtos) {
        double soma = 0.0;

        for(ProdutoDTO produto : produtos) {
            if(produto.getCodigo() == 1) soma+= 20.0;
            if(produto.getCodigo() == 2) soma+= 10.0;
            if(produto.getCodigo() == 3) soma+= 15.0;
        }

        return soma;
    }

   public int calculaImpostoSubtotal(double subtotal) {
     if(subtotal > 50) {
         double count = subtotal%50;
         return (int) count/100;
     }

     return 0;
   }

    public double calculaImpostoComposto(List<ProdutoDTO> produtos) {
        double soma = 0.0;

        for(ProdutoDTO produto: produtos) {
            if(produto.getCodigo() == 1 && produto.getPreco() < 25.0) soma+= 30.0;
            if(produto.getCodigo() == 1 && produto.getPreco() > 25.0) soma+= 10.0;
            if(produto.getCodigo() == 2 && produto.getPreco() > 25.0) soma+= 50.0;
            if(produto.getCodigo() == 2 && produto.getPreco() < 25.0) soma+= 12.0;
            if(produto.getCodigo() == 3 && produto.getPreco() > 25.0) soma+= 70.0;
            if(produto.getCodigo() == 3 && produto.getPreco() < 25.0) soma+= 7.0;
        }

        return soma;
    }
}
