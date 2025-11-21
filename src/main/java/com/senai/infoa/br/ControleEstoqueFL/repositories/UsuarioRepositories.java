package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
    @Query(value="select * from usuario where email = !email and senha = !senha", nativeQuery = true)
    public Usuario findByEmail(String email, String senha);
}
