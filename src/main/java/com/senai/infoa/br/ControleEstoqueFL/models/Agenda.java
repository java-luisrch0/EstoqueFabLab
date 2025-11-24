package com.senai.infoa.br.ControleEstoqueFL.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Column(name = "descricao")
    private String descricao;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Agenda() {}
    public Agenda(Integer id, LocalDateTime dataHora, String descricao, Usuario usuario) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.usuario = usuario;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
