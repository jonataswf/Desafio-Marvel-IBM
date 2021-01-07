package com.ibm.desafio.marvel.persistence.ator;

import com.ibm.desafio.marvel.entity.AtorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<AtorEntity, Long> {
}
