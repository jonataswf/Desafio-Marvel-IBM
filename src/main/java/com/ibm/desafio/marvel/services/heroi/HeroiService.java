package com.ibm.desafio.marvel.services.heroi;

import com.ibm.desafio.marvel.model.Heroi;
import com.ibm.desafio.marvel.persistence.heroi.HeroiPersistence;
import com.ibm.desafio.marvel.services.validate.CriadorValidate;
import com.ibm.desafio.marvel.services.validate.HeroiValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiService {

    @Autowired
    HeroiPersistence heroiPersistence;

    @Autowired
    HeroiValidate heroiValidate;

    @Autowired
    CriadorValidate criadorValidate;

    public Heroi save(Heroi heroi) {
        criadorValidate.validateAllCreationsOfCreatorLimtedBy5(heroi.getCriador());
        heroiValidate.limitFiveHeroiByFilmeAndRevista(heroi.getRevista(), heroi.getFilme());
        return heroiPersistence.save(heroi);
    }

    public List<Heroi> findAll() {
        return heroiPersistence.findAll();
    }

    public String deleteById(Long id) {
        heroiValidate.validateId(id);
        return heroiPersistence.deleteById(id);
    }

    public Heroi findById(Long id) {
        heroiValidate.validateId(id);
        return heroiPersistence.findById(id);
    }

    public String deleteAll() {
        return heroiPersistence.deleteAll();
    }

    public Heroi updateById(Long id, Heroi heroi) {
        heroiValidate.validateId(id);
        criadorValidate.validateAllCreationsOfCreatorLimtedBy5(heroi.getCriador());
        heroiValidate.limitFiveHeroiByFilmeAndRevista(heroi.getRevista(), heroi.getFilme());
        return heroiPersistence.updateById(id, heroi);
    }
}
