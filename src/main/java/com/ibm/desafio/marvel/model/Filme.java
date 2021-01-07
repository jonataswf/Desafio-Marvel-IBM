package com.ibm.desafio.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme {

    private Long id;

    @JsonProperty(value = "movie_name")
    private String movieName;

    @JsonProperty(value = "release_year")
    private Integer releaseYear;

    @JsonProperty(value = "fk_criador_id")
    private Long criador;
}
