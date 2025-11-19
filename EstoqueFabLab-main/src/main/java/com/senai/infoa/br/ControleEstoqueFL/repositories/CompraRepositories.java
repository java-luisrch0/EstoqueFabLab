package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infoa.br.ControleEstoqueFL.models.Compra;

public interface CompraRepositories extends JpaRepository<Compra, Integer> {
    
}
