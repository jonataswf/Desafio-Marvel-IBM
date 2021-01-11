package com.ibm.desafio.marvel.services.revista;

import com.ibm.desafio.marvel.model.Revista;
import com.ibm.desafio.marvel.persistence.revista.RevistaPersistence;
import com.ibm.desafio.marvel.services.validate.CriadorValidate;
import com.ibm.desafio.marvel.services.validate.RevistaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevistaService {

    @Autowired
    RevistaPersistence revistaPersistence;

    @Autowired
    RevistaValidate revistaValidate;

    @Autowired
    CriadorValidate criadorValidate;

    public Revista save(Revista revista) {
        criadorValidate.validateAllCreationsOfCreatorLimtedBy5(revista.getCriador());
        return revistaPersistence.save(revista);
    }

    public List<Revista> findAll() {
        return revistaPersistence.findAll();
    }

    public String deleteById(Long id) {
        revistaValidate.validateId(id);
        return revistaPersistence.deleteById(id);
    }

    public Revista findById(Long id) {
        revistaValidate.validateId(id);
        return revistaPersistence.findById(id);
    }

    public String deleteAll() {
        return revistaPersistence.deleteAll();
    }

    public Revista updateById(Long id, Revista revista) {
        revistaValidate.validateId(id);
        criadorValidate.validateAllCreationsOfCreatorLimtedBy5(revista.getCriador());
        return revistaPersistence.updateById(id, revista);
    }
}
