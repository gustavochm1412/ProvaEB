package com.example.demo.service;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TrabalhoService trabalhoService;
    public Pessoa criarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<PessoaDTO> listarPessoas(){
        return pessoaRepository.findAll().stream().map(pessoa -> pessoa.converterParaDto()).collect(Collectors.toList());
    }

    public PessoaDTO buscarPessoa(int id){
        return pessoaRepository.findById(id).orElseThrow().converterParaDto();
    }

    public Pessoa atualizarPessoa(int id, Pessoa pessoa){
        Pessoa pessoaSelecionada=pessoaRepository.findById(id).orElseThrow();
        pessoaSelecionada.setNome(pessoa.getNome());
        pessoaSelecionada.setDataNascimento(pessoa.getDataNascimento());
        return pessoaRepository.save(pessoaSelecionada);
    }

    public Pessoa deletarPessoa(int id){
        Pessoa pessoaSelecionada=pessoaRepository.findById(id).orElseThrow();
        pessoaRepository.delete(pessoaSelecionada);
        return pessoaSelecionada;
    }

    public Pessoa adicionarTrabalho(int id, int trabalhoId){
        Pessoa pessoaSelecionada=pessoaRepository.findById(id).orElseThrow();
        Trabalho trabalhoSelecionado=trabalhoService.buscarTrabalho(trabalhoId);

        pessoaSelecionada.setTrabalho(trabalhoSelecionado);

        return pessoaRepository.save(pessoaSelecionada);
    }
}
