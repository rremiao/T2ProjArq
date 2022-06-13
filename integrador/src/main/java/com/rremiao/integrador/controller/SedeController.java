package com.rremiao.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rremiao.integrador.integration.MSIntegrator;

@RestController
@RequestMapping("/sede")
public class SedeController {
    
    @Autowired
    MSIntegrator integrador;
    
}
