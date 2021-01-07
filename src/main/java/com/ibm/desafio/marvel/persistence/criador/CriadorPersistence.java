package com.ibm.desafio.marvel.persistence.criador;

import com.ibm.desafio.marvel.entity.CriadorEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Criador;
import com.ibm.desafio.marvel.parse.CriadorParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CriadorPersistence extends Messages {

    @Autowired
    CriadorRepository criadorRepository;

    @Autowired
    CriadorParser criadorParser;

    public Criador save(Criador criador) {
        CriadorEntity criadorEntity = criadorParser.parse(criador);
        criadorRepository.save(criadorEntity);
        Criador saveCriador = criadorParser.parse(criadorEntity);
        return saveCriador;
    }

    public List<Criador> findAll() {
        List<CriadorEntity> criadorEntities = criadorRepository.findAll();
        List<Criador> criadores = new ArrayList<>();
        for (CriadorEntity i : criadorEntities) {
            Criador criador = criadorParser.parse(i);
            criadores.add(criador);
        }
        return criadores;
    }

    public String deleteById(Long id) {
        try {
            criadorRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Criador findById(Long id) {
        Optional<CriadorEntity> criadorEntity = criadorRepository.findById(id);
        Criador criador = criadorParser.parse(criadorEntity.get());
        return criador;
    }

    public String deleteAll() {
        criadorRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Criador updateById(Long id, Criador criador) {
            CriadorEntity criadorEntity = criadorParser.parse(criador);
            criadorEntity.setId(id);
            criadorRepository.save(criadorEntity);
            return criadorParser.parse(criadorEntity);
    }

    public CriadorEntity getOne(Long criador) {
        CriadorEntity criadorEntity = criadorRepository.getOne(criador);
        return criadorEntity;
    }
}