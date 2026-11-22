package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmRequest {

    @NotBlank
    private String titre;

    private String genre;

    private Integer anneeSortie;

    private Integer dureeMinutes;
}
