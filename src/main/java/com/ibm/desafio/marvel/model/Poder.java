package com.ibm.desafio.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Poder {

    private Long id;

    @JsonProperty("power_name")
    private String powerName;

    @JsonProperty("power_description")
    private String powerDescription;

    @JsonProperty(value = "fk_hero_id")
    private Long hero;
}
