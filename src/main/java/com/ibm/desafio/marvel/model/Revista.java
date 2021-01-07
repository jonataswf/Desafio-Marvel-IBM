package com.ibm.desafio.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Revista {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("publishing_company")
    private String publishingCompany;

    @JsonProperty(value = "fk_criador_id")
    private Long criador;

}
