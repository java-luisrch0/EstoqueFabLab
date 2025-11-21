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
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.br.ControleEstoqueFL.models.Item;
import com.senai.infoa.br.ControleEstoqueFL.services.ItemServices;

@RequestMapping("/item")
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
        return is.atualizar(item, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = is.delete(id);
        if (deletou) {
            return "Item deletado com sucesso";
        }
        return "Falha ao deletar o item";
    }

    @PostMapping("/cadastro")
    public Item salvar(@RequestBody Item item) {
        return is.salvar(item);
    }
}
