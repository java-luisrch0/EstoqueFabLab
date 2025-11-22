package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Compra;
import com.senai.infoa.br.ControleEstoqueFL.repositories.CompraRepositories;

@Service
public class CompraServices {
    @Autowired
    private CompraRepositories cr;

    public List<Compra> listarTodos() {
        return cr.findAll();
    }

    public Compra buscarPorId(@NonNull Integer id) {
        return cr.findById(id).get();
    }

    public Compra atualizar(@NonNull Integer id, @NonNull Compra compra) {
        Compra e = buscarPorId(id);
        if (e != null) {
            compra.setid(id);
            return cr.save(compra);
        }
        return null;
    }

    public boolean delete(@NonNull Integer id) {
        Compra compra = cr.findById(id).get();
        if(compra != null) {
            cr.deleteById(id);
            return true;
            
        }
        return false;
    }

    public Compra salvar(@NonNull Compra compra) {
        return cr.save(compra);
    }
}
