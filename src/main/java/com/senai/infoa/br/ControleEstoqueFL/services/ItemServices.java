package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Agenda;
import com.senai.infoa.br.ControleEstoqueFL.models.Compra;
import com.senai.infoa.br.ControleEstoqueFL.models.Item;
import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.repositories.AgendaRepositories;
import com.senai.infoa.br.ControleEstoqueFL.repositories.CompraRepositories;
import com.senai.infoa.br.ControleEstoqueFL.repositories.ItemRepositories;
import com.senai.infoa.br.ControleEstoqueFL.repositories.UsuarioRepositories;

@Service
public class ItemServices {
    @Autowired
    private ItemRepositories ir;
    @Autowired 
    private UsuarioRepositories ur;
    @Autowired 
    private AgendaRepositories ar;
    @Autowired
    private CompraRepositories cr;

    public List<Item> listarTodos() {
        return ir.findAll();
    }

    public Item buscarPorId(Integer id) {
        return ir.findById(id).get();
    }
    public Item atualizar(Item item, Integer id) {
        Item i = buscarPorId(id);
        if (i != null) {
            item.setId(id);
            return ir.save(item);
        }
        return null;
    }

    public boolean delete(Integer id) {
        Item item = ir.findById(id).get();
        if(item != null) {
            ir.deleteById(id);
            return true;
            
        }
        return false;
    }

    public Item salvar(@NonNull Item item) {
        
        Usuario usuarioAntigo = ur.findById(item.getUsuario().getId()).orElseThrow(()-> new RuntimeException("Não existe esse usuario"));

        Usuario usuario = new Usuario();
        usuarioAntigo.setId(item.getUsuario().getId());
        item.setUsuario(usuario);

        Compra compraAntiga = cr.findById(item.getCompra().getId()).orElseThrow(()-> new RuntimeException("Não existe essa compra"));

        Compra compra = new Compra();
        compraAntiga.setId(item.getCompra().getId());
        item.setCompra(compra);

        Agenda agendaAntiga = ar.findById(item.getAgenda().getId()).orElseThrow(()-> new RuntimeException("Não existe essa agenda"));

        Agenda agenda = new Agenda();
        agendaAntiga.setId(item.getAgenda().getId());
        item.setAgenda(agenda);
        
        return ir.save(item);
    }
}
