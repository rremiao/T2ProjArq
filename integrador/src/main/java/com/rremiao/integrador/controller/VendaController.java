package com.rremiao.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    MSIntegrator integrador;

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public void confirmaVenda(@RequestBody final String itens) {
        
    }

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public void calculaSubtotal(@RequestBody final String param) {
        
    }

}
