package com.senai.infoa.br.ControleEstoqueFL.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AgendaControllers {
    @Autowired
    private AgendaUsuarios as;
    
    @PutMapping("/atualizar/{id}")
    public Agenda atualizar(@PathVariable Integer id, @RequestBody Agenda agenda) {
        return as.atualizar(agenda, id);
    }

    @GetMapping("/lista")
    public List<Agenda> listarTodos() {
        return as.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Agenda buscarPorId(@PathVariable Integer id) {
        return as.buscarPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = as.delete(id);
        if (deletou) {
            return "Compra cancelada com sucesso";
        }
        return "Falha ao cancelar a compra";
    }

    @PostMapping("/cadastro")
    public Agenda salvar(@RequestBody Agenda agenda) {
        return as.salvar(agenda);
    }
}
