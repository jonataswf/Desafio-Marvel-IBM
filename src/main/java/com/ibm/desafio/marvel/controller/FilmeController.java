package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Filme;
import com.ibm.desafio.marvel.services.filme.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/filme")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping("/add")
    public Filme save(@RequestBody Filme filme) {
        return filmeService.save(filme);
    }

    @GetMapping("/find/all")
    public List<Filme> findAll() {
        return filmeService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Filme findById(@PathVariable(name = "id") Long id) {
        return filmeService.findById(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return filmeService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return filmeService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Filme updateById(@PathVariable(name = "id") Long id, @RequestBody Filme filme) {
        return filmeService.updateById(id, filme);
    }

}