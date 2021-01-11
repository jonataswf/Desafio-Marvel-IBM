package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeValidate extends Messages {

    @Autowired
    FilmeRepository filmeRepository;

    public void validateId(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }
}