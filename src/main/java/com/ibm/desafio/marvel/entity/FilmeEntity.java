package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "filme")
@Getter
@Setter
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "fk_id_criador", referencedColumnName = "id")
    private CriadorEntity criador;

}
