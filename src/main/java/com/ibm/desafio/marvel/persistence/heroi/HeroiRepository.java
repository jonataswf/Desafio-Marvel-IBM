package com.ibm.desafio.marvel.persistence.heroi;

import com.ibm.desafio.marvel.entity.HeroiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroiRepository extends JpaRepository<HeroiEntity, Long> {

    public List<HeroiEntity> findByRevista_Id(Long id);
    public List<HeroiEntity> findByFilme_Id(Long id);
    public List<HeroiEntity> findByCriador_Id(Long id);

}
