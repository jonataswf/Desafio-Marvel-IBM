package com.ibm.desafio.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Heroi {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty(value = "fk_criador_id")
    private Long criador;

    @JsonProperty("fk_revista_id")
    private Long revista;

    @JsonProperty(value = "fk_filme_id")
    private Long filme;

}
