package com.example.demo.service;

import com.example.demo.model.Trabalho;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Trabalho criarTrabalho(Trabalho trabalho){
        return trabalhoRepository.save(trabalho);
    }

    public List<Trabalho> listarTrabalhos(){
        return trabalhoRepository.findAll();
    }

    public Trabalho buscarTrabalho(int id){
        return trabalhoRepository.findById(id).orElseThrow();
    }

    public Trabalho atualizarTrabalho(int id, Trabalho trabalho){
        Trabalho trabalhoSelecionado=trabalhoRepository.findById(id).orElseThrow();
        trabalhoSelecionado.setNome(trabalho.getNome());
        trabalhoSelecionado.setDescricao(trabalho.getDescricao());
        return trabalhoRepository.save(trabalho);
    }

    public Trabalho deletarTrabalho(int id){
        Trabalho trabalhoSelecionado=trabalhoRepository.findById(id).orElseThrow();
        trabalhoRepository.deleteById(id);
        return trabalhoSelecionado;
    }
}
