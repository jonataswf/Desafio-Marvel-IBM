package com.ibm.desafio.marvel.persistence.poder;

import com.ibm.desafio.marvel.entity.PoderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoderRepository extends JpaRepository<PoderEntity, Long> {
}
