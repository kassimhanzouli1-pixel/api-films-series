package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EpisodeResponse {

    private Long id;
    private String titre;
    private Integer numeroSaison;
    private Integer numeroEpisode;
    private Integer dureeMinutes;
    private Long serieId;
}