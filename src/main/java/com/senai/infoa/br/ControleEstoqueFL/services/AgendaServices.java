package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Agenda;
import com.senai.infoa.br.ControleEstoqueFL.repositories.AgendaRepositories;



@Service
public class AgendaServices {
    @Autowired
    private AgendaRepositories ar;

    public List<Agenda> listarTodos() {
        return ar.findAll();
    }

    public Agenda atualizar(@NonNull Agenda agenda, @NonNull Integer id) {
        Agenda e = buscarPorId(id);
        if (e != null) {
            agenda.setId(id);
            return ar.save(agenda);
        }
        return null;
    }

    public boolean delete(@NonNull Integer id) {
        Agenda agenda = ar.findById(id).get();
        if(agenda != null) {
            ar.deleteById(id);
            return true;
            
        }
        return false;
    }
    public Agenda buscarPorId(@NonNull Integer id) {
        return ar.findById(id).get();
    }
    
    public Agenda salvar(@NonNull Agenda agenda) {
        return ar.save(agenda);

    }

}
