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

import com.senai.infoa.br.ControleEstoqueFL.models.Agenda;
import com.senai.infoa.br.ControleEstoqueFL.services.AgendaServices;

@RequestMapping
@RestController
public class AgendaControllers {
    @Autowired
    private AgendaServices as;
    
    @PutMapping("/atualizar/{id}")
    public Agenda atualizar(@PathVariable Integer id, @RequestBody Agenda agenda) {
        return (Agenda) as.atualizar(agenda, id);
    }

    @GetMapping("/lista")
    public List<Agenda> listarTodos() {
        return (List<Agenda>) as.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Agenda buscarPorId(@PathVariable Integer id) {
        return (Agenda) as.buscarPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = as.delete(id);
        if (deletou) {
            return "Agendamento cancelado com sucesso";
        }
        return "Falha ao cancelar o agendamento";
    }

    @PostMapping("/cadastro")
    public Agenda salvar(@RequestBody Agenda agenda) {
        return (Agenda) as.salvar(agenda);
    }
}
