package com.ibm.desafio.marvel.services.ator;

import com.ibm.desafio.marvel.model.Ator;
import com.ibm.desafio.marvel.persistence.ator.AtorPersistence;
import com.ibm.desafio.marvel.services.validate.AtorValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    AtorPersistence atorPersistence;

    @Autowired
    AtorValidate atorValidate;

    public Ator save(Ator ator) {
        atorValidate.validateRepeatedIdHero(ator.getHero());
        return atorPersistence.save(ator);
    }

    public List<Ator> findAll() {
        return atorPersistence.findAll();
    }

    public String deleteById(Long id) {
        atorValidate.validateId(id);
        return atorPersistence.deleteById(id);
    }

    public Ator findById(Long id) {
        atorValidate.validateId(id);
        return atorPersistence.findById(id);
    }

    public String deleteAll() {
        return atorPersistence.deleteAll();
    }

    public Ator updateById(Long id, Ator ator) {
        atorValidate.validateId(id);
        return atorPersistence.updateById(id, ator);
    }
}
