package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilmResponse {

    private Long id;
    private String titre;
    private String genre;
    private Integer anneeSortie;
    private Integer dureeMinutes;
}
