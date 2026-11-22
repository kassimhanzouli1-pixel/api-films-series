package com.basespringboot.service;

import com.basespringboot.dto.FilmRequest;
import com.basespringboot.dto.FilmResponse;
import java.util.List;

public interface FilmService {

    FilmResponse createFilm(FilmRequest filmRequest);

    List<FilmResponse> getAllFilms();

    FilmResponse getFilmById(Long id);

    FilmResponse updateFilm(Long id, FilmRequest filmRequest);

    void deleteFilm(Long id);
}
