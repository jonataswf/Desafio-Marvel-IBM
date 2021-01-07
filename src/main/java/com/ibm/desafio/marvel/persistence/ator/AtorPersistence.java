package com.ibm.desafio.marvel.persistence.ator;

import com.ibm.desafio.marvel.entity.AtorEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Ator;
import com.ibm.desafio.marvel.parse.AtorParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AtorPersistence extends Messages {

    @Autowired
    AtorRepository atorRepository;

    @Autowired
    AtorParser atorParser;

    public Ator save(Ator ator) {
        AtorEntity atorEntity = atorParser.parse(ator);
        atorRepository.save(atorEntity);
        Ator saveAtor = atorParser.parse(atorEntity);
        return saveAtor;
    }

    public List<Ator> findAll() {
        List<AtorEntity> atorEntities = atorRepository.findAll();
        List<Ator> atores = new ArrayList<>();
        for (AtorEntity i : atorEntities) {
            Ator ator = atorParser.parse(i);
            atores.add(ator);
        }
        return atores;
    }

    public String deleteById(Long id) {
        try {
            atorRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Ator findById(Long id) {
        Optional<AtorEntity> atorEntity = atorRepository.findById(id);
        Ator ator = atorParser.parse(atorEntity.get());
        return ator;
    }

    public String deleteAll() {
        atorRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Ator updateById(Long id, Ator ator) {
        AtorEntity atorEntity = atorParser.parse(ator);
        atorEntity.setId(id);
        atorRepository.save(atorEntity);
        return atorParser.parse(atorEntity);
    }
}