package com.ibm.desafio.marvel.services.poder;

import com.ibm.desafio.marvel.model.Poder;
import com.ibm.desafio.marvel.persistence.poder.PoderPersistence;
import com.ibm.desafio.marvel.services.validate.PoderValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoderService {

    @Autowired
    PoderPersistence poderPersistence;

    @Autowired
    PoderValidate poderValidate;

    public Poder save(Poder poder) {
        return poderPersistence.save(poder);
    }

    public List<Poder> findAll() {
        return poderPersistence.findAll();
    }

    public String deleteById(Long id) {
        poderValidate.validateId(id);
        return poderPersistence.deleteById(id);
    }

    public Poder findById(Long id) {
        poderValidate.validateId(id);
        return poderPersistence.findById(id);
    }

    public String deleteAll() {
        return poderPersistence.deleteAll();
    }

    public Poder updateById(Long id, Poder poder) {
        poderValidate.validateId(id);
        return poderPersistence.updateById(id, poder);
    }
}
