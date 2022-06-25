package com.rremiao.enderecoservice.core.operation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rremiao.enderecoservice.business.entity.Endereco;

@Transactional
public interface EnderecoOperationRepository extends JpaRepository<Endereco, Integer>{
    
}
