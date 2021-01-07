package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.AtorEntity;
import com.ibm.desafio.marvel.model.Ator;
import com.ibm.desafio.marvel.persistence.heroi.HeroiPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtorParser {

    @Autowired
    HeroiPersistence heroiPersistence;

    public AtorEntity parse(Ator ator) {
        AtorEntity atorEntity = new AtorEntity();
        atorEntity.setName(ator.getName());
        atorEntity.setSurname(ator.getSurname());
        atorEntity.setHero(heroiPersistence.getOne(ator.getHero()));
        return atorEntity;
    }

    public Ator parse(AtorEntity atorEntity) {
        Ator ator = new Ator();
        ator.setId(atorEntity.getId());
        ator.setName(atorEntity.getName());
        ator.setSurname(atorEntity.getSurname());
        ator.setHero(atorEntity.getHero().getId());
        return ator;
    }
}