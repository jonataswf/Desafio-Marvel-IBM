package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Poder;
import com.ibm.desafio.marvel.services.poder.PoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/poder")
public class PoderController {

    @Autowired
    PoderService poderService;

    @PostMapping("/add")
    public Poder save(@RequestBody Poder poder) {
        return poderService.save(poder);
    }

    @GetMapping("/find/all")
    public List<Poder> findAll() {
        return poderService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Poder findById(@PathVariable(name = "id") Long id) {
        return poderService.findById(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return poderService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return poderService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Poder updateById(@PathVariable(name = "id") Long id, @RequestBody Poder poder) {
        return poderService.updateById(id, poder);
    }

}