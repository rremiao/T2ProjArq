package com.rremiao.enderecoservice.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rremiao.enderecoservice.business.dto.EnderecoDTO;
import com.rremiao.enderecoservice.core.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository repository;

    public EnderecoDTO buscaEndereco(int codigo) {
        return repository.buscaEndereco(codigo);
    }
}
