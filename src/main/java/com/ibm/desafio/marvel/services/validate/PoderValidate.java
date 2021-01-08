package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.PoderEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Poder;
import com.ibm.desafio.marvel.parse.PoderParser;
import com.ibm.desafio.marvel.persistence.poder.PoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoderValidate extends Messages {

    @Autowired
    PoderRepository poderRepository;

    @Autowired
    PoderParser poderParser;

    public void validateId(Long id) {
        if (!poderRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

//    public void validateIdHeroLessThan5(Long id) {
//        List<PoderEntity> poderEntities = poderRepository.findAll();
//        for (PoderEntity i : poderEntities) {
//            Poder poder = poderParser.parse(i);
//            Long poder_id = poder.getHero();
//        }
//    }
}