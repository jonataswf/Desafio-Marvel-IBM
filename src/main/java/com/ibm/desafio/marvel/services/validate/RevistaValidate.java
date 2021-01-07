package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.RevistaEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Revista;
import com.ibm.desafio.marvel.parse.RevistaParser;
import com.ibm.desafio.marvel.persistence.revista.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevistaValidate extends Messages {

    @Autowired
    RevistaRepository revistaRepository;

    @Autowired
    RevistaParser revistaParser;

    public void validateId(Long id) {
        if (!revistaRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void validateRepeatedIdCriador(Long id) {
        List<RevistaEntity> revistaEntities = revistaRepository.findAll();
        for (RevistaEntity i : revistaEntities) {
            Revista revista = revistaParser.parse(i);
            if (revista.getCriador().equals(id)) {
                throw new RuntimeException(id + FK_CRIADOR_ID_REVISTA);
            }
        }
    }
}