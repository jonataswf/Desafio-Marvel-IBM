package com.ibm.desafio.marvel.persistence.revista;

import com.ibm.desafio.marvel.entity.RevistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevistaRepository extends JpaRepository<RevistaEntity, Long> {

    public List<RevistaEntity> findByCriador_Id(Long id);
}
