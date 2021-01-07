package com.ibm.desafio.marvel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "criador")
@Getter
@Setter
public class CriadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

}
