package com.ibm.desafio.marvel.persistence.heroi;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Heroi;
import com.ibm.desafio.marvel.parse.HeroiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HeroiPersistence extends Messages {

    @Autowired
    HeroiRepository heroiRepository;

    @Autowired
    HeroiParser heroiParser;

    public Heroi save(Heroi heroi) {
        HeroiEntity heroiEntity = heroiParser.parse(heroi);
        heroiRepository.save(heroiEntity);
        Heroi saveHeroi = heroiParser.parse(heroiEntity);
        return saveHeroi;
    }

    public List<Heroi> findAll() {
        List<HeroiEntity> heroiEntities = heroiRepository.findAll();
        List<Heroi> herois = new ArrayList<>();
        for (HeroiEntity i : heroiEntities) {
            Heroi heroi = heroiParser.parse(i);
            herois.add(heroi);
        }
        return herois;
    }

    public String deleteById(Long id) {
        try {
            heroiRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Heroi findById(Long id) {
        Optional<HeroiEntity> heroiEntity = heroiRepository.findById(id);
        Heroi heroi = heroiParser.parse(heroiEntity.get());
        return heroi;
    }

    public String deleteAll() {
        heroiRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Heroi updateById(Long id, Heroi heroi) {
        HeroiEntity heroiEntity = heroiParser.parse(heroi);
        heroiEntity.setId(id);
        heroiRepository.save(heroiEntity);
        return heroiParser.parse(heroiEntity);
    }

    public HeroiEntity getOne(Long hero) {
        HeroiEntity heroiEntity = heroiRepository.getOne(hero);
        return heroiEntity;
    }
}