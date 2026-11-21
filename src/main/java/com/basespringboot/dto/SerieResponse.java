package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SerieResponse {

    private Long id;
    private String titre;
    private String genre;
    private Integer anneeDebut;
}
