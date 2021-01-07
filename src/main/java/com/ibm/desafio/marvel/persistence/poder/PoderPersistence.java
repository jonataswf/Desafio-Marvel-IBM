package com.ibm.desafio.marvel.persistence.poder;

import com.ibm.desafio.marvel.entity.PoderEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Poder;
import com.ibm.desafio.marvel.parse.PoderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PoderPersistence extends Messages {

    @Autowired
    PoderRepository poderRepository;

    @Autowired
    PoderParser poderParser;

    public Poder save(Poder poder) {
        PoderEntity poderEntity = poderParser.parse(poder);
        poderRepository.save(poderEntity);
        Poder savePoder = poderParser.parse(poderEntity);
        return savePoder;
    }

    public List<Poder> findAll() {
        List<PoderEntity> poderEntities = poderRepository.findAll();
        List<Poder> poderes = new ArrayList<>();
        for (PoderEntity i : poderEntities) {
            Poder poder = poderParser.parse(i);
            poderes.add(poder);
        }
        return poderes;
    }

    public String deleteById(Long id) {
        try {
            poderRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Poder findById(Long id) {
        Optional<PoderEntity> poderEntity = poderRepository.findById(id);
        Poder poder = poderParser.parse(poderEntity.get());
        return poder;
    }

    public String deleteAll() {
        poderRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Poder updateById(Long id, Poder poder) {
        PoderEntity poderEntity = poderParser.parse(poder);
        poderEntity.setId(id);
        poderRepository.save(poderEntity);
        return poderParser.parse(poderEntity);
    }
}