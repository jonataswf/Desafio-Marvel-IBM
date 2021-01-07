package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "poder")
@Getter
@Setter
public class PoderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "power_name")
    private String powerName;

    @Column(name = "power_description")
    private String powerDescription;

    @ManyToOne
    @JoinColumn(name = "fk_id_hero", referencedColumnName = "id")
    private HeroiEntity hero;
}
