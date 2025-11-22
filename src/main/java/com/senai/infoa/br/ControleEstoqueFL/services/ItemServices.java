package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Item;
import com.senai.infoa.br.ControleEstoqueFL.repositories.ItemRepositories;

@Service
public class ItemServices {
    @Autowired
    private ItemRepositories ir;

    public List<Item> listarTodos() {
        return ir.findAll();
    }

    public Item buscarPorId(@NonNull Integer id) {
        return ir.findById(id).get();
    }

    public Item atualizar(@NonNull Item item, @NonNull Integer id) {
        Item e = buscarPorId(id);
        if (e != null) {
            item.setId(id);
            return ir.save(item);
        }
        return null;
    }

    public boolean delete(@NonNull Integer id) {
        Item item = ir.findById(id).get();
        if(item != null) {
            ir.deleteById(id);
            return true;
            
        }
        return false;
    }

    public Item salvar(@NonNull Item item) {
        return ir.save(item);
    }
}
