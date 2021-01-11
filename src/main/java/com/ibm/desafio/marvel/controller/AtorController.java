package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Ator;
import com.ibm.desafio.marvel.services.ator.AtorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/ator")
public class AtorController {

    @Autowired
    AtorService atorService;

    @PostMapping("/add")
    public Ator save(@RequestBody Ator ator) {
        return atorService.save(ator);
    }

    @GetMapping("/find/all")
    public List<Ator> findAll() {
        return atorService.findAll();
    }

    @GetMapping("/find/{id}")
    public Ator findById(@PathVariable(name = "id") Long id) {
        return atorService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return atorService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return atorService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Ator updateById(@PathVariable(name = "id") Long id, @RequestBody Ator ator) {
        return atorService.updateById(id, ator);
    }

}