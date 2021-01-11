package com.ibm.desafio.marvel.controller;

import com.ibm.desafio.marvel.model.Heroi;
import com.ibm.desafio.marvel.services.heroi.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/heroi")
public class HeroiController {

    @Autowired
    HeroiService heroiService;

    @PostMapping("/add")
    public Heroi save(@RequestBody Heroi heroi) {
        return heroiService.save(heroi);
    }

    @GetMapping("/find/all")
    public List<Heroi> findAll() {
        return heroiService.findAll();
    }

    @GetMapping("/find/{id}")
    public Heroi findById(@PathVariable(name = "id") Long id) {
        return heroiService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return heroiService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return heroiService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public Heroi updateById(@PathVariable(name = "id") Long id, @RequestBody Heroi heroi) {
        return heroiService.updateById(id, heroi);
    }

}