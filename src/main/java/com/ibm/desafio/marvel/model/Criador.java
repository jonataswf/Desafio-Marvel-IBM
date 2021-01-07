package com.ibm.desafio.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criador {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;
}
