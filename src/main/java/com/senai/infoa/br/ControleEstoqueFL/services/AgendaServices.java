package com.senai.infoa.br.ControleEstoqueFL.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.senai.infoa.br.ControleEstoqueFL.models.Agenda;
import com.senai.infoa.br.ControleEstoqueFL.models.Usuario;
import com.senai.infoa.br.ControleEstoqueFL.repositories.AgendaRepositories;
import com.senai.infoa.br.ControleEstoqueFL.repositories.UsuarioRepositories;




@Service
public class AgendaServices {
    @Autowired
    private AgendaRepositories ar;
    @Autowired 
    private UsuarioRepositories ur;

    public List<Agenda> listarTodos() {
        return ar.findAll();
    }

    public Agenda atualizar(Agenda agenda, Integer id) {
        Agenda a = buscarPorId(id);
        if (a != null) {
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
    
    public Agenda salvar(@NonNull Agenda agenda) {
        
        Usuario usuarioAntigo = ur.findById(agenda.getUsuario().getId()).orElseThrow(()-> new RuntimeException("Não existe esse usuario"));

        Usuario usuario = new Usuario();
        usuarioAntigo.setId(agenda.getUsuario().getId());
        agenda.setUsuario(usuario);
        
        
        return ar.save(agenda);
    }

}
