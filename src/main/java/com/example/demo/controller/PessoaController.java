package com.example.demo.controller;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.criarPessoa(pessoa), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PessoaDTO>> listarPessoas(){
        return new ResponseEntity<>(pessoaService.listarPessoas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoa(@PathVariable int id){
        try{
            return new ResponseEntity<>(pessoaService.buscarPessoa(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa nao encontrada", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa){
        try{
            return new ResponseEntity<>(pessoaService.atualizarPessoa(id, pessoa), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa nao encontrada", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletarPessoa(@PathVariable int id){
        try{
            return new ResponseEntity<>(pessoaService.deletarPessoa(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa nao encontrada", e);
        }
    }

    @PatchMapping("/{id}/adicionarTrabalho/{idTrabalho}")
    public ResponseEntity<Pessoa> adicionarTrabalho(@PathVariable(value = "id") int id, @PathVariable(value = "idTrabalho") int idTrabalho){
        try{
            return new ResponseEntity<>(pessoaService.adicionarTrabalho(id, idTrabalho), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa ou trabalho nao encontrado", e);
        }
    }
}
