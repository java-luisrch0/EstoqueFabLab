package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.infoa.br.ControleEstoqueFL.repositories.AgendaRepositories;
import com.senai.infoa.br.ControleEstoqueFL.models.Agenda;



@Service
public class AgendaServices {
    @Autowired
    private AgendaRepositories ar;

    public List<Agenda> listarTodos() {
        return ar.findAll();
    }

    public Agenda atualizar(Agenda agenda, Integer id) {
        Agenda e = buscarPorId(id);
        if (e != null) {
            agenda.setId(id);
            return ar.save(agenda);
        }
        return null;
    }

    public boolean delete(Integer id) {
        Agenda agenda = ar.findById(id).get();
        if(agenda != null) {
            ar.deleteById(id);
            return true;
            
        }
        return false;
    }
    public Agenda buscarPorId(Integer id) {
        return ar.findById(id).get();
    }

    public Agenda salvar(Agenda agenda) {
        return ar.save(agenda);
    }
}
