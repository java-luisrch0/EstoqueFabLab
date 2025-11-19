package com.senai.infoa.br.ControleEstoqueFL.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.senai.infoa.ControleEstoqueFL.repositories.ItemRepositories;
import com.senai.infoa.ControleEstoqueFL.models.Item;

@Service
public class ItemServices {
    @Autowired
    private ItemRepositories ir;

    public List<Item> listarTodos() {
        return ir.findAll();
    }

    public Item buscarPorId(Integer id) {
        return ir.findById(id).get();
    }

    public Item atualizar(Item item, Integer id) {
        Item e = buscarPorId(id);
        if (e != null) {
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

    public Item salvar(Item item) {
        return ir.save(item);
    }
}
