package com.ibm.desafio.marvel.persistence.criador;

import com.ibm.desafio.marvel.entity.CriadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriadorRepository extends JpaRepository<CriadorEntity, Long> {
}
