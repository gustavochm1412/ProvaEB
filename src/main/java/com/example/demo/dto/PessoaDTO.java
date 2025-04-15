package com.example.demo.dto;

import com.example.demo.model.Trabalho;

public class PessoaDTO {
    private String nome;

    private Trabalho trabalho;

    public PessoaDTO(String nome, Trabalho trabalho) {
        this.nome = nome;
        this.trabalho = trabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
