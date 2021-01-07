package com.ibm.desafio.marvel.parse;

import com.ibm.desafio.marvel.entity.CriadorEntity;
import com.ibm.desafio.marvel.model.Criador;
import org.springframework.stereotype.Component;

@Component
public class CriadorParser {

    public CriadorEntity parse(Criador criador) {
        CriadorEntity criadorEntity = new CriadorEntity();
        criadorEntity.setName(criador.getName());
        criadorEntity.setSurname(criador.getSurname());
        return criadorEntity;
    }

    public Criador parse(CriadorEntity criadorEntity) {
        Criador criador = new Criador();
        criador.setId(criadorEntity.getId());
        criador.setName(criadorEntity.getName());
        criador.setSurname(criadorEntity.getSurname());
        return criador;
    }

}
