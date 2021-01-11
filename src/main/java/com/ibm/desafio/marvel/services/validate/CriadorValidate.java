package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.FilmeEntity;
import com.ibm.desafio.marvel.entity.HeroiEntity;
import com.ibm.desafio.marvel.entity.RevistaEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.criador.CriadorRepository;
import com.ibm.desafio.marvel.persistence.filme.FilmeRepository;
import com.ibm.desafio.marvel.persistence.heroi.HeroiRepository;
import com.ibm.desafio.marvel.persistence.revista.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriadorValidate extends Messages {

    @Autowired
    CriadorRepository criadorRepository;

    @Autowired
    HeroiRepository heroiRepository;

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    RevistaRepository revistaRepository;

    public void validateId(Long id) {
        if (!criadorRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void validateAllCreationsOfCreatorLimtedBy5(Long id) {
        List<HeroiEntity> heroiEntities = heroiRepository.findByCriador_Id(id);
        List<FilmeEntity> filmeEntities = filmeRepository.findByCriador_Id(id);
        List<RevistaEntity> revistaEntities = revistaRepository.findByCriador_Id(id);

        if (heroiEntities.size() + filmeEntities.size() + revistaEntities.size() >= 5) {
            throw new RuntimeException(CRIADOR_ID + id + LIMIT_CRIACOES_5);
        }
    }
}