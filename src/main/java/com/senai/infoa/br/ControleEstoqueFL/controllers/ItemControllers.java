package com.senai.infoa.br.ControleEstoqueFL.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RestController
public class ItemControllers {
    @Autowired
    private ItemServices is;

    @GetMapping("/lista")
    public List<Item> listarTodos() {
        return is.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Item buscarPorId(@PathVariable Integer id) {
        return is.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Item atualizar(@PathVariable Integer id, @RequestBody Item item) {
        return is.atualizar(categoria, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = is.delete(id);
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
