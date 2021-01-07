package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.FilmeEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Filme;
import com.ibm.desafio.marvel.parse.FilmeParser;
import com.ibm.desafio.marvel.persistence.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeValidate extends Messages {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    FilmeParser filmeParser;

    public void validateId(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void validateRepeatedIdCriador(Long id) {
        List<FilmeEntity> filmeEntities = filmeRepository.findAll();
        for (FilmeEntity i : filmeEntities) {
            Filme filme = filmeParser.parse(i);
            if (filme.getCriador().equals(id)) {
                throw new RuntimeException(id + FK_CRIADOR_ID_FILME);
            }
        }
    }

    public String validateRepeatedIdCriadorUpdate(Long id, Filme f) {
        List<FilmeEntity> filmeEntities = filmeRepository.findAll();
        for (FilmeEntity i : filmeEntities) {
            Filme filme = filmeParser.parse(i);
            if (!filme.getCriador().equals(id) && filme.getId().equals(f.getId())) {
                throw new RuntimeException(id + FK_CRIADOR_ID_FILME);
            }
        }
        return "atualizado com sucesso";
    }
}