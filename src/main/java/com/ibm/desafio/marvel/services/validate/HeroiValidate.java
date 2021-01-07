package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.parse.HeroiParser;
import com.ibm.desafio.marvel.persistence.heroi.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiValidate extends Messages {

    @Autowired
    HeroiRepository heroiRepository;

    @Autowired
    HeroiParser heroiParser;

    public void validateId(Long id) {
        if (!heroiRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

//    public void limitFiveHeroiByRevista() {
//        List<HeroiEntity> herois = heroiRepository.findByRevista_Id();
//        if (herois.size() > 5) {
//            throw new RuntimeException("teste");
//        }
//    }
}