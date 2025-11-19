package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senai.infoa.br.ControleEstoqueFL.models.Item;
@Repository
public interface ItemRepositories extends JpaRepository<Item, Integer> {
    
}
