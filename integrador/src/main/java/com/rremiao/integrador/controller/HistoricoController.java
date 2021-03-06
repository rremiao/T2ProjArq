package com.rremiao.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.business.dto.VendaDTO;
import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    @Autowired
    MSIntegrator integrador;

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public List<VendaDTO> vendasEfetuadas() {
      return integrador.vendasEfetuadas();
    }
    
}
