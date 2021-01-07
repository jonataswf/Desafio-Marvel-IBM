package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Revista;
import com.ibm.desafio.marvel.services.revista.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/revista")
public class RevistaController {

    @Autowired
    RevistaService revistaService;

    @PostMapping("/add")
    public Revista save(@RequestBody Revista revista) {
        return revistaService.save(revista);
    }

    @GetMapping("/find/all")
    public List<Revista> findAll() {
        return revistaService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Revista findById(@PathVariable(name = "id") Long id) {
        return revistaService.findById(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return revistaService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return revistaService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Revista updateById(@PathVariable(name = "id") Long id, @RequestBody Revista revista) {
        return revistaService.updateById(id, revista);
    }

}