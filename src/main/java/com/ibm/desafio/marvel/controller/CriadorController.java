package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Criador;
import com.ibm.desafio.marvel.services.criador.CriadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/criador")
public class CriadorController {

    @Autowired
    CriadorService criadorService;

    @PostMapping("/add")
    public Criador save(@RequestBody Criador criador) {
        return criadorService.save(criador);
    }

    @GetMapping("/find/all")
    public List<Criador> findAll() {
        return criadorService.findAll();
    }

    @GetMapping("/find/{id}")
    public Criador findById(@PathVariable(name = "id") Long id) {
        return criadorService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return criadorService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return criadorService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Criador updateById(@PathVariable(name = "id") Long id, @RequestBody Criador criador) {
        return criadorService.updateById(id, criador);
    }

}