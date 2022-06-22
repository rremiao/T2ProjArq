package com.rremiao.enderecoservice.core.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rremiao.enderecoservice.business.dto.EnderecoDTO;
import com.rremiao.enderecoservice.business.entity.Endereco;
import com.rremiao.enderecoservice.business.interfaces.IEnderecoRepository;
import com.rremiao.enderecoservice.core.operation.EnderecoOperationRepository;

public class EnderecoRepository extends IEnderecoRepository{
    
    @Autowired
    EnderecoOperationRepository operationRepository;

    public EnderecoDTO buscaEndereco(int codigo) {
        EnderecoDTO addr = new EnderecoDTO();

        Optional<Endereco> optAddr = operationRepository.findById(codigo);
        Endereco myAddr = optAddr.get();

        addr.withLogradouro(myAddr.getLogradouro())
            .withNumero(myAddr.getNumero())
            .withComplemento(myAddr.getComplemento())
            .withEstado(myAddr.getEstado())
            .withCep(myAddr.getCep())
            .withBairro(myAddr.getBairro())
            .withCidade(myAddr.getCidade());

        
        return addr;       
    }
}
