package com.senai.infoa.br.ControleEstoqueFL.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.repositories.UsuarioRepositories;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepositories ur;

        public Usuario salvar(Usuario usuario) {
        return ur.save(usuario);
    }
        public Usuario buscarPorId(Integer id) {
        return ur.findById(id).get();
    }
    public Usuario atualizar(Usuario usuario, Integer id) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            usuario.setId(id);
            return ur.login(usuario);
        }
        return null;
    }
    }

