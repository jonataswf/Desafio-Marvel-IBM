package com.ibm.desafio.marvel.persistence.revista;

import com.ibm.desafio.marvel.entity.RevistaEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Revista;
import com.ibm.desafio.marvel.parse.RevistaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RevistaPersistence extends Messages {

    @Autowired
    RevistaRepository revistaRepository;

    @Autowired
    RevistaParser revistaParser;

    public Revista save(Revista revista) {
        RevistaEntity revistaEntity = revistaParser.parse(revista);
        revistaRepository.save(revistaEntity);
        Revista saveRevista = revistaParser.parse(revistaEntity);
        return saveRevista;
    }

    public List<Revista> findAll() {
        List<RevistaEntity> revistaEntities = revistaRepository.findAll();
        List<Revista> revistas = new ArrayList<>();
        for (RevistaEntity i : revistaEntities) {
            Revista revista = revistaParser.parse(i);
            revistas.add(revista);
        }
        return revistas;
    }

    public String deleteById(Long id) {
        try {
            revistaRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Revista findById(Long id) {
        Optional<RevistaEntity> revistaEntity = revistaRepository.findById(id);
        Revista revista = revistaParser.parse(revistaEntity.get());
        return revista;
    }

    public String deleteAll() {
        revistaRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Revista updateById(Long id, Revista revista) {
        RevistaEntity revistaEntity = revistaParser.parse(revista);
        revistaEntity.setId(id);
        revistaRepository.save(revistaEntity);
        return revistaParser.parse(revistaEntity);
    }

    public RevistaEntity getOne(Long revista) {
        RevistaEntity revistaEntity = revistaRepository.getOne(revista);
        return revistaEntity;
    }
}