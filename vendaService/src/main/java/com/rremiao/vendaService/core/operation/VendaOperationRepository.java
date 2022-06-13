package com.rremiao.vendaService.core.operation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rremiao.vendaService.business.entity.Venda;

@Transactional
public interface VendaOperationRepository extends JpaRepository<Venda, Integer> {
    
}
