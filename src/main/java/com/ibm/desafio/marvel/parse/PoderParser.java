package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.PoderEntity;
import com.ibm.desafio.marvel.model.Poder;
import com.ibm.desafio.marvel.persistence.heroi.HeroiPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PoderParser {

    @Autowired
    HeroiPersistence heroiPersistence;

    public PoderEntity parse(Poder poder) {
        PoderEntity poderEntity = new PoderEntity();
        poderEntity.setPowerName(poder.getPowerName());
        poderEntity.setPowerDescription(poder.getPowerDescription());
        poderEntity.setHero(heroiPersistence.getOne(poder.getHero()));
        return poderEntity;
    }

    public Poder parse(PoderEntity poderEntity) {
        Poder poder = new Poder();
        poder.setId(poderEntity.getId());
        poder.setPowerName(poderEntity.getPowerName());
        poder.setPowerDescription(poderEntity.getPowerDescription());
        poder.setHero(poderEntity.getHero().getId());
        return poder;
    }
}
