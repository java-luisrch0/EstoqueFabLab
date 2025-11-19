package com.senai.infoa.br.ControleEstoqueFL.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.senai.infoa.ControleEstoqueFL.repositories.CompraRepositories;
import com.senai.infoa.ControleEstoqueFL.models.Compra;

@Service
public class CompraServices {
    @Autowired
    private CompraRepositories cr;

    public List<Compra> listarTodos() {
        return cr.findAll();
    }

    public Compra buscarPorId(Integer id) {
        return cr.findById(id).get();
    }

    public Compra atualizar(Compra compra, Integer id) {
        Compra e = buscarPorId(id);
        if (e != null) {
            compra.setId(id);
            return cr.save(compra);
        }
        return null;
    }

    public boolean delete(Integer id) {
        Compra compra = cr.findById(id).get();
        if(compra != null) {
            cr.deleteById(id);
            return true;
            
        }
        return false;
    }

    public Compra salvar(Compra compra) {
        return cr.save(compra);
    }
}
