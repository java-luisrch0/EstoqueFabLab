package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senai.infoa.br.ControleEstoqueFL.models.Compra;
@Repository
public interface CompraRepositories extends JpaRepository<Compra, Integer> {
    
}
