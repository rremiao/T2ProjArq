package com.rremiao.produtoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.rremiao.produtoservice.business.dto.ProdutoDTO;
import com.rremiao.produtoservice.core.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> listaProdutos() {
      return produtoService.listaProdutos();
    }

    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public boolean podeVender(@RequestParam final Integer codigo,
                              @RequestParam final Integer quantidade) {
      return produtoService.podeVender(codigo, quantidade);
    }

    @GetMapping("/buscaProduto")
    @CrossOrigin(origins = "*")
    public ProdutoDTO buscaProduto(@RequestParam(name = "codigo") Integer codigo) {
        return produtoService.buscaProduto(codigo);
    }

    @PostMapping("/calculaImposto")
    @CrossOrigin(origins = "*")
    public double calculaImpostoSimples(@RequestBody final String produtos) {

      ObjectMapper mapper = new ObjectMapper();

      List<ProdutoDTO> myItems = new ArrayList<>();
       try {
        myItems = mapper.readValue(produtos, new TypeReference<List<ProdutoDTO>>() {});
      } catch (JsonMappingException e) {
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      return produtoService.calculaImpostoSimples(myItems);
    }

    @GetMapping("/healthcheck")
    @CrossOrigin(origins = "*")
    public boolean healthcheck() {
      return true;
    }
}
