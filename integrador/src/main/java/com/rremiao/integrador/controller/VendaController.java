package com.rremiao.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.business.dto.ParamSubtotal_DTO;
import com.rremiao.integrador.business.dto.PrecosDTO;
import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    MSIntegrator integrador;

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public boolean confirmaVenda(@RequestBody final String itens) {
        return integrador.confirmaVenda(itens);
    }

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public PrecosDTO calculaSubtotal(@RequestBody final ParamSubtotal_DTO param) {
        return integrador.calculaSubtotal(param);
    }

}
