package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import com.ibm.desafio.marvel.model.Heroi;
import com.ibm.desafio.marvel.persistence.criador.CriadorPersistence;
import com.ibm.desafio.marvel.persistence.filme.FilmePersistence;
import com.ibm.desafio.marvel.persistence.revista.RevistaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeroiParser {

    @Autowired
    RevistaPersistence revistaPersistence;

    @Autowired
    FilmePersistence filmePersistence;

    @Autowired
    CriadorPersistence criadorPersistence;

    public HeroiEntity parse(Heroi heroi) {
        HeroiEntity heroiEntity = new HeroiEntity();
        heroiEntity.setName(heroi.getName());
        heroiEntity.setCriador(criadorPersistence.getOne(heroi.getCriador()));
        heroiEntity.setRevista(revistaPersistence.getOne(heroi.getRevista()));
        heroiEntity.setFilme(filmePersistence.getOne(heroi.getFilme()));
        return heroiEntity;
    }

    public Heroi parse(HeroiEntity heroiEntity) {
        Heroi heroi = new Heroi();
        heroi.setId(heroiEntity.getId());
        heroi.setName(heroiEntity.getName());
        heroi.setCriador(heroiEntity.getCriador().getId());
        heroi.setRevista(heroiEntity.getRevista().getId());
        heroi.setFilme(heroiEntity.getFilme().getId());
        return heroi;
    }
}
