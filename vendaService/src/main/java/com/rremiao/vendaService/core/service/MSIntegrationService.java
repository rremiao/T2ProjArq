package com.rremiao.vendaService.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rremiao.vendaService.business.dto.EnderecoDTO;
import com.rremiao.vendaService.business.dto.ProdutoDTO;

@Service
public class MSIntegrationService {
    
    public List<ProdutoDTO> listaProdutos(){
        ResponseEntity<ProdutoDTO[]> forEntity = new RestTemplate().getForEntity("http://localhost:8008/produto-service/", ProdutoDTO[].class);

        List<ProdutoDTO> listaProdutos = new ArrayList<>();

        listaProdutos = Arrays.asList(forEntity.getBody());

		return listaProdutos;
    }

    public double calculaImpostoSimples(List<ProdutoDTO> produtos) {
        ResponseEntity<Double> forEntity = new RestTemplate().postForEntity("http://localhost:8008/produto-service/calculaImpostoSimples", produtos, Double.class);

        return forEntity.getBody();
    }

    public EnderecoDTO buscaEndereco(Integer id) {
        ResponseEntity<EnderecoDTO> forEntity = new RestTemplate().getForEntity("http://localhost:8008/endereco-service/buscaEndereco", EnderecoDTO.class, id);
        
        return forEntity.getBody();
    }

}
