package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeRequest {

    @NotBlank
    private String titre;

    private Integer numeroSaison;

    private Integer numeroEpisode;

    private Integer dureeMinutes;

    @NotNull
    private Long serieId;
}