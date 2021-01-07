package com.ibm.desafio.marvel.services.filme;

import com.ibm.desafio.marvel.model.Filme;
import com.ibm.desafio.marvel.persistence.filme.FilmePersistence;
import com.ibm.desafio.marvel.services.validate.FilmeValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmePersistence filmePersistence;

    @Autowired
    FilmeValidate filmeValidate;

    public Filme save(Filme filme) {
        filmeValidate.validateRepeatedIdCriador(filme.getCriador());
        return filmePersistence.save(filme);
    }

    public List<Filme> findAll() {
        return filmePersistence.findAll();
    }

    public String deleteById(Long id) {
        filmeValidate.validateId(id);
        return filmePersistence.deleteById(id);
    }

    public Filme findById(Long id) {
        filmeValidate.validateId(id);
        return filmePersistence.findById(id);
    }

    public String deleteAll() {
        return filmePersistence.deleteAll();
    }

    public Filme updateById(Long id, Filme filme) {
        filmeValidate.validateId(id);
        return filmePersistence.updateById(id, filme);
    }
}
