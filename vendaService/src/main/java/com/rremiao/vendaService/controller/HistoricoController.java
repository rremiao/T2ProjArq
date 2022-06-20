package com.rremiao.vendaService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.vendaService.core.service.VendaService;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    
    @Autowired
    VendaService vendaService;

    @GetMapping("/healthcheck")
    @CrossOrigin(origins = "*")
    public boolean healthcheck() {
      return true;
    }
}