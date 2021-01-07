package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.criador.CriadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriadorValidate extends Messages {

    @Autowired
    CriadorRepository criadorRepository;

    public void validateId(Long id) {
        if (!criadorRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }
}