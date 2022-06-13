package com.rremiao.vendaService.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rremiao.vendaService.business.dto.ItemCarrinhoDTO;
import com.rremiao.vendaService.business.dto.ParamSubtotal_DTO;
import com.rremiao.vendaService.business.dto.PrecosDTO;
import com.rremiao.vendaService.business.dto.VendaDTO;

@Repository
public interface IVendaRepository {
    public boolean confirmaVenda(final List<ItemCarrinhoDTO> itens);
    
    public PrecosDTO calculaSubtotal(final ParamSubtotal_DTO param);

    public List<VendaDTO> listaVenda();
}
