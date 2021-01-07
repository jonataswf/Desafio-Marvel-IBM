package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ator")
@Getter
@Setter
public class AtorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "fk_id_hero", referencedColumnName = "id", unique = true)
    private HeroiEntity hero;

}
