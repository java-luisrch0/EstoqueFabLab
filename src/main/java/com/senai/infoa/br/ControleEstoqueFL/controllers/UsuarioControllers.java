package com.senai.infoa.br.ControleEstoqueFL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.services.UsuarioServices;

@RestController
public class UsuarioControllers {
    @Autowired
    private UsuarioServices us;
    
    @PostMapping("/cadastroUsuario")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return us.salvar(usuario);
    }

    @PostMapping("/loginUsuario")
    public Usuario login(@RequestBody Usuario usuario) {
        return us.login(usuario);
    }


}
