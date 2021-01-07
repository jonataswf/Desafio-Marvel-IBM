package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.RevistaEntity;
import com.ibm.desafio.marvel.model.Revista;
import com.ibm.desafio.marvel.persistence.criador.CriadorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RevistaParser {

    @Autowired
    CriadorPersistence criadorPersistence;

    public RevistaEntity parse(Revista revista) {
        RevistaEntity revistaEntity = new RevistaEntity();
        revistaEntity.setName(revista.getName());
        revistaEntity.setPublishingCompany(revista.getPublishingCompany());
        revistaEntity.setCriador(criadorPersistence.getOne(revista.getCriador()));
        return revistaEntity;
    }

    public Revista parse(RevistaEntity revistaEntity) {
        Revista revista = new Revista();
        revista.setId(revistaEntity.getId());
        revista.setName(revistaEntity.getName());
        revista.setPublishingCompany(revistaEntity.getPublishingCompany());
        revista.setCriador(revistaEntity.getCriador().getId());
        return revista;
    }
}