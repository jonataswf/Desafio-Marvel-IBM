package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.heroi.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiValidate extends Messages {

    @Autowired
    HeroiRepository heroiRepository;

    public void validateId(Long id) {
        if (!heroiRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void limitFiveHeroiByFilmeAndRevista(Long idRevista, Long idFilme) {
        List<HeroiEntity> heroiEntities1 = heroiRepository.findByRevista_Id(idRevista);
        List<HeroiEntity> heroiEntities2 = heroiRepository.findByFilme_Id(idFilme);

        if (heroiEntities1.size() >= 5 && heroiEntities2.size() >= 5){
            throw new RuntimeException(REVISTA_ID + idRevista + FILME_ID + idFilme + LIMIT_HEROI_5);
        }

        if (heroiEntities1.size() >= 5) {
            throw new RuntimeException(REVISTA_ID + idRevista + LIMIT_HEROI_5);
        }

        if (heroiEntities2.size() >= 5) {
            throw new RuntimeException(FILME_ID + idFilme + LIMIT_HEROI_5);
        }
    }
}