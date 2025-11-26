package com.senai.infoa.br.ControleEstoqueFL.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.br.ControleEstoqueFL.models.Compra;
import com.senai.infoa.br.ControleEstoqueFL.services.CompraServices;


@RequestMapping("/compra")
@RestController
public class CompraControllers {
    @Autowired
    private CompraServices cs;

    @GetMapping("/lista")
    public List<Compra> listarTodos() {
        return cs.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Compra buscarPorId(@PathVariable Integer id) {
        return cs.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Compra atualizar(@PathVariable Integer id, @RequestBody @NonNull Compra compra) {
        return cs.atualizar(id, compra);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = cs.delete(id);
        if (deletou) {
            return "Compra cancelada com sucesso";
        }
        return "Falha ao cancelar a compra";
    }

    @PostMapping("/salvar")
    public Compra salvar(@RequestBody @NonNull Compra compra) {
        return cs.salvar(compra);
    }


}
