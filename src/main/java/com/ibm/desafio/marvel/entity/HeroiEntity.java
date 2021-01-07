package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "heroi")
@Getter
@Setter
public class HeroiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_id_criador", referencedColumnName = "id")
    private CriadorEntity criador;

    @ManyToOne
    @JoinColumn(name = "fk_id_revista", referencedColumnName = "id")
    private RevistaEntity revista;

    @ManyToOne
    @JoinColumn(name = "fk_id_filme", referencedColumnName = "id")
    private FilmeEntity filme;

}
