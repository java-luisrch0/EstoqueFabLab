package com.senai.infoa.br.ControleEstoqueFL.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.services.UsuarioServices;

@RequestMapping
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
