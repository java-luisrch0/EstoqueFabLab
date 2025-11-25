package com.senai.infoa.br.ControleEstoqueFL.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.repositories.UsuarioRepositories;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepositories ur;

    public Usuario save(@NonNull Usuario usuario) {
        return ur.save(usuario);
    }
        
    public Usuario buscarPorId(int id) {
        return ur.findById(id).get();
    }
    
    public Usuario atualizar(@NonNull Usuario usuario, int id) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            usuario.setId(id);
            return ur.save(usuario);
        }
        return null;
    }

    public boolean delete(int id) {
        Usuario usuario = ur.findById(id).get();
        if(usuario != null) {
            ur.deleteById(id);
            return true;
            
        }
        return false;
    }

    public List<Usuario> listarTodos() {
        return ur.findAll();
    }

    public Usuario login(String email, String senha, String funcao) {
        Usuario usuario = ur.findByUsuario(email, senha, funcao);
        if (usuario != null && senha.equals(usuario.getSenha()) && funcao.equals(usuario.getFuncao())) {
            return usuario;
        }
        return null;
    }
}

