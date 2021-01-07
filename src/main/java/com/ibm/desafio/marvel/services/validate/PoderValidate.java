package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.parse.PoderParser;
import com.ibm.desafio.marvel.persistence.poder.PoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void validateRepeatedIdHeroLessThan5(Long id) {

    }
}