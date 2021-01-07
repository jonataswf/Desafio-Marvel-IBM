package com.ibm.desafio.marvel.services.criador;

import com.ibm.desafio.marvel.model.Criador;
import com.ibm.desafio.marvel.persistence.criador.CriadorPersistence;
import com.ibm.desafio.marvel.services.validate.CriadorValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriadorService {

    @Autowired
    CriadorPersistence criadorPersistence;

    @Autowired
    CriadorValidate criadorValidate;

    public Criador save(Criador criador) {
        return criadorPersistence.save(criador);
    }

    public List<Criador> findAll() {
        return criadorPersistence.findAll();
    }

    public String deleteById(Long id) {
        criadorValidate.validateId(id);
        return criadorPersistence.deleteById(id);
    }

    public Criador findById(Long id) {
        criadorValidate.validateId(id);
        return criadorPersistence.findById(id);
    }

    public String deleteAll() {
        return criadorPersistence.deleteAll();
    }

    public Criador updateById(Long id, Criador criador) {
        criadorValidate.validateId(id);
        return criadorPersistence.updateById(id, criador);
    }
}
