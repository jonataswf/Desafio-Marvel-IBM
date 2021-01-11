package com.ibm.desafio.marvel.persistence.filme;

import com.ibm.desafio.marvel.entity.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {

    public List<FilmeEntity> findByCriador_Id(Long id);
}
