package com.ibm.desafio.marvel.persistence.revista;

import com.ibm.desafio.marvel.entity.RevistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends JpaRepository<RevistaEntity, Long> {
}
