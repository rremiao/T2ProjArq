package com.rremiao.estoqueService.business.dto;

public class EstoqueDTO {
    private int id;

    private int estoqueMinimo;

    private int idProduto;

    public EstoqueDTO(int id, int estoqueMinimo, int idProduto) {
        this.id = id;
        this.estoqueMinimo = estoqueMinimo;
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    } 

    public EstoqueDTO withId(int id) {
        this.id = id;
        return this;
    }

    public EstoqueDTO withEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
        return this;
    }
    
    public EstoqueDTO withIdProduto(int idProduto) {
        this.idProduto = idProduto;
        return this;
    }
}
