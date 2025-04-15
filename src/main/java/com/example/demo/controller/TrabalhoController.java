package com.example.demo.controller;

import com.example.demo.model.Trabalho;
import com.example.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping("")
    public ResponseEntity<Trabalho> criarTrabalho(@RequestBody Trabalho trabalho){
        return new ResponseEntity<>(trabalhoService.criarTrabalho(trabalho), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Trabalho>> listarTrabalhos(){
        return new ResponseEntity<>(trabalhoService.listarTrabalhos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabalho> buscarTrabalho(@PathVariable int id){
        try{
            return new ResponseEntity<>(trabalhoService.buscarTrabalho(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho nao encontrado", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabalho> atualizarTrabalho(@PathVariable int id, @RequestBody Trabalho trabalho){
        try{
            return new ResponseEntity<>(trabalhoService.atualizarTrabalho(id, trabalho), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho nao encontrado", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trabalho> deletarTrabalho(@PathVariable int id){
        try{
            return new ResponseEntity<>(trabalhoService.deletarTrabalho(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho nao encontrado", e);
        }
    }
}
