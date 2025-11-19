package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;

public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
    
}
