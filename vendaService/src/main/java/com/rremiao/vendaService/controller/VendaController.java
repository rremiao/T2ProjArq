package com.rremiao.vendaService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.vendaService.business.dto.ParamSubtotal_DTO;
import com.rremiao.vendaService.business.dto.PrecosDTO;
import com.rremiao.vendaService.core.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    VendaService vendaService;

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public boolean confirmaVenda(@RequestBody final String itens) {
        return vendaService.confirmaVenda(itens);
    }

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public PrecosDTO calculaSubtotal(@RequestBody final ParamSubtotal_DTO param) {    
        return vendaService.calculaSubtotal(param);
    }

    @GetMapping("/healthcheck")
    @CrossOrigin(origins = "*")
    public boolean healthcheck() {
      return true;
    }
}
