package com.ibm.desafio.marvel.persistence.heroi;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends JpaRepository<HeroiEntity, Long> {

}
