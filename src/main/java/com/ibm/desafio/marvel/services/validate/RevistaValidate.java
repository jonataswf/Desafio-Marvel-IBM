package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.revista.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevistaValidate extends Messages {

    @Autowired
    RevistaRepository revistaRepository;

    public void validateId(Long id) {
        if (!revistaRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }
}