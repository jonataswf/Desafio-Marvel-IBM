package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.FilmeEntity;
import com.ibm.desafio.marvel.model.Filme;
import com.ibm.desafio.marvel.persistence.criador.CriadorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmeParser {

    @Autowired
    CriadorPersistence criadorPersistence;

    public FilmeEntity parse(Filme filme) {
        FilmeEntity filmeEntity = new FilmeEntity();
        filmeEntity.setMovieName(filme.getMovieName());
        filmeEntity.setReleaseYear(filme.getReleaseYear());
        filmeEntity.setCriador(criadorPersistence.getOne(filme.getCriador()));
        return filmeEntity;
    }

    public Filme parse(FilmeEntity filmeEntity) {
        Filme filme = new Filme();
        filme.setId(filmeEntity.getId());
        filme.setMovieName(filmeEntity.getMovieName());
        filme.setReleaseYear(filmeEntity.getReleaseYear());
        filme.setCriador(filmeEntity.getCriador().getId());
        return filme;
    }
}