package com.senai.infoa.br.ControleEstoqueFL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
    @Query(value="select * from usuario where email = email and senha = senha and funcao = funcao", nativeQuery = true)
    public Usuario findByUsuario(@Param("email") String email,@Param("senha") String senha,@Param("funcao") String funcao);
}
