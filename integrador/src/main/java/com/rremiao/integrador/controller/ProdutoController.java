package com.rremiao.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.business.dto.ProdutoDTO;
import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    MSIntegrator integrador;
    
    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> listaProdutos() {
        return integrador.listaProdutos();
    }

    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public boolean podeVender(@RequestParam final Integer codigo,
                           @RequestParam final Integer quantidade) {
        
        return integrador.podeVender(codigo, quantidade);
    }

    @GetMapping("/buscaProduto")
    @CrossOrigin(origins = "*")
    public ProdutoDTO buscaProduto(@RequestParam(name = "codigo")Integer codigo) {
        return integrador.buscaProduto(codigo);
    }


}
