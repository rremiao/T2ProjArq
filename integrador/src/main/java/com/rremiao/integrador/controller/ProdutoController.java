package com.rremiao.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    MSIntegrator integrador;
    
    @GetMapping()
    @CrossOrigin(origins = "*")
    public void listaProdutos() {

    }

    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public void podeVender(@RequestParam final Integer codigo,
                           @RequestParam final Integer quantidade) {
        

    }

    @GetMapping("/buscaProduto")
    @CrossOrigin(origins = "*")
    public void buscaProduto(@RequestParam(name = "codigo")Integer codigo) {

    }


}
