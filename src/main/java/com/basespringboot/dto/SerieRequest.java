package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerieRequest {

    @NotBlank
    private String titre;

    private String genre;

    private Integer anneeDebut;
}
