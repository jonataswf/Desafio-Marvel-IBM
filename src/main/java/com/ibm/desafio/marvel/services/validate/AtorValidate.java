package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.AtorEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Ator;
import com.ibm.desafio.marvel.parse.AtorParser;
import com.ibm.desafio.marvel.persistence.ator.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorValidate extends Messages {

    @Autowired
    AtorRepository atorRepository;

    @Autowired
    AtorParser atorParser;

    public void validateId(Long id) {
        if (!atorRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void validateRepeatedIdHero(Long id) {
        List<AtorEntity> atorEntities = atorRepository.findAll();
        for (AtorEntity i : atorEntities) {
            Ator ator = atorParser.parse(i);
            if (ator.getHero().equals(id)) {
                throw new RuntimeException(HEROI_ID + id + HEROI_ATRIBUIDO);
            }
        }
    }
}