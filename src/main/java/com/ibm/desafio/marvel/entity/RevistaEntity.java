package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "revista")
@Getter
@Setter
public class RevistaEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "publishing_company")
    private String publishingCompany;

    @ManyToOne
    @JoinColumn(name = "fk_id_criador", referencedColumnName = "id")
    private CriadorEntity criador;
}
