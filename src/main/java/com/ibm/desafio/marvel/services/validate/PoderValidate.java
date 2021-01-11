package com.ibm.desafio.marvel.services.validate;

import com.ibm.desafio.marvel.entity.PoderEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.persistence.poder.PoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoderValidate extends Messages {

    @Autowired
    PoderRepository poderRepository;

    public void validateId(Long id) {
        if (!poderRepository.existsById(id)) {
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    public void validateIdHeroLessEqualThan5(Long id) {
        List<PoderEntity> poderEntities = poderRepository.findByHero_id(id);
        if (poderEntities.size() >= 5) {
            throw new RuntimeException(HEROI_ID + id + LIMIT_PODER_5);
        }
    }
}