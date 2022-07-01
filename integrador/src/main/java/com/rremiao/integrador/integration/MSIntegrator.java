package com.rremiao.integrador.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rremiao.integrador.business.dto.ParamSubtotal_DTO;
import com.rremiao.integrador.business.dto.PrecosDTO;
import com.rremiao.integrador.business.dto.ProdutoDTO;
import com.rremiao.integrador.business.dto.VendaDTO;

@Component
public class MSIntegrator {
    
    public List<VendaDTO> vendasEfetuadas() {
        ResponseEntity<VendaDTO[]> forEntity = new RestTemplate().getForEntity("http://localhost:8008/historico/", VendaDTO[].class);

        List<VendaDTO> listaVendas = new ArrayList<>();

        listaVendas = Arrays.asList(forEntity.getBody());

		return listaVendas;
    }

    public List<ProdutoDTO> listaProdutos() {
        ResponseEntity<ProdutoDTO[]> forEntity = new RestTemplate().getForEntity("http://gateway:8008/produto-service/", ProdutoDTO[].class);

        List<ProdutoDTO> listaProdutos = new ArrayList<>();

        listaProdutos = Arrays.asList(forEntity.getBody());

		return listaProdutos;
    }

    public boolean podeVender(Integer codigo, Integer quantidade) {

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("codigo", codigo);
        params.put("quantidade", quantidade);

        ResponseEntity<Boolean> forEntity = new RestTemplate().postForEntity("http://api-gateway:8008/produto-service/autorizacao", params, Boolean.class);

        return forEntity.getBody();
    }

    public ProdutoDTO buscaProduto(Integer codigo) {
        ResponseEntity<ProdutoDTO> forEntity = new RestTemplate().exchange("http://api-gateway:8008/produto-service/buscaProduto", HttpMethod.GET, null,ProdutoDTO.class, codigo);

		return forEntity.getBody();
    }

    public boolean confirmaVenda(String itens) {
        ResponseEntity<Boolean> forEntity = new RestTemplate().postForEntity("http://api-gateway:8008/venda-service/confirmacao", itens, Boolean.class);

        return forEntity.getBody();
    }

    public PrecosDTO calculaSubtotal(ParamSubtotal_DTO param) {
        ResponseEntity<PrecosDTO> forEntity = new RestTemplate().postForEntity("http://api-gateway:8008/venda-service/subtotal", param, PrecosDTO.class);

        return forEntity.getBody();
    }
}
