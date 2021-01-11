package com.ibm.desafio.marvel.persistence.filme;

import com.ibm.desafio.marvel.entity.FilmeEntity;
import com.ibm.desafio.marvel.messages.Messages;
import com.ibm.desafio.marvel.model.Filme;
import com.ibm.desafio.marvel.parse.FilmeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FilmePersistence extends Messages {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    FilmeParser filmeParser;

    public Filme save(Filme filme) {
        FilmeEntity filmeEntity = filmeParser.parse(filme);
        filmeRepository.save(filmeEntity);
        Filme saveFilme = filmeParser.parse(filmeEntity);
        return saveFilme;
    }

    public List<Filme> findAll() {
        List<FilmeEntity> filmeEntities = filmeRepository.findAll();
        List<Filme> filmes = new ArrayList<>();
        for (FilmeEntity i : filmeEntities) {
            Filme filme = filmeParser.parse(i);
            filmes.add(filme);
        }
        return filmes;
    }

    public String deleteById(Long id) {
        try {
            filmeRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ERRO_AO_DELETAR;
        }
        return DELETADO_COM_SUCESSO;
    }

    public Filme findById(Long id) {
        Optional<FilmeEntity> filmeEntity = filmeRepository.findById(id);
        Filme filme = filmeParser.parse(filmeEntity.get());
        return filme;
    }

    public String deleteAll() {
        filmeRepository.deleteAll();
        return DADOS_TABELA_DELETADOS;
    }

    public Filme updateById(Long id, Filme filme) {
        FilmeEntity filmeEntity = filmeParser.parse(filme);
        filmeEntity.setId(id);
        filmeRepository.save(filmeEntity);
        return filmeParser.parse(filmeEntity);
    }

    public FilmeEntity getOne(Long filme) {
        FilmeEntity filmeEntity = filmeRepository.getOne(filme);
        return filmeEntity;
    }
}