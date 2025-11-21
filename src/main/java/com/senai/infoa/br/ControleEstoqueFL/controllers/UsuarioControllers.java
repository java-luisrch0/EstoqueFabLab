package com.senai.infoa.br.ControleEstoqueFL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.services.UsuarioServices;

@RequestMapping("/usuario")
@RestController
public class UsuarioControllers {
    @Autowired
    private UsuarioServices us;
    
    @PostMapping("/cadastroUsuario")
    public Usuario save(@RequestBody Usuario usuario) {
        return us.save(usuario);
    }

    @PostMapping("/loginUsuario")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return us.login(email, senha);
    }

    @GetMapping("/lista")
    public List<Usuario> listarTodos() {
        return us.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return us.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return us.atualizar(usuario, id);

    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = us.delete(id);
        if (deletou) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover o usuário";
    }
}
