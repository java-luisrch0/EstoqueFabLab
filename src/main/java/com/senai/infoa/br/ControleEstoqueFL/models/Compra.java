package com.senai.infoa.br.ControleEstoqueFL.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "produto")
    private String produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "preco")
    private Double preco;

    public Compra() {}
    public Compra(Integer id, String produto, Integer quantidade, String categoria, Double preco) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.preco = preco;
    }





    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getproduto() {
        return produto;
    }

    public void setproduto(String produto) {
        this.produto = produto;
    }

    public Integer getquantidade() {
        return quantidade;
    }

    public void setquantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getcategoria() {
        return categoria;
    }

    public void setcategoria(String categoria) {
        this.categoria = categoria;
    }
    public Double getpreco() {
        return preco;
    }

    public void setpreco(Double preco) {
        this.preco = preco;
    }

    

}
