package com.rremiao.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    MSIntegrator integrador;

}