package com.rremiao.produtoservice.core.operation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rremiao.produtoservice.business.entity.Produto;

@Transactional
public interface ProdutoOperationRepository extends JpaRepository<Produto, Integer> {
    
}
