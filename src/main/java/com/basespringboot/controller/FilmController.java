package com.basespringboot.controller;

import com.basespringboot.dto.FilmRequest;
import com.basespringboot.dto.FilmResponse;
import com.basespringboot.service.FilmService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FilmResponse createFilm(@Valid @RequestBody FilmRequest filmRequest) {
        return this.filmService.createFilm(filmRequest);
    }

    @GetMapping
    public List<FilmResponse> getAllFilms() {
        return this.filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public FilmResponse getFilmById(@PathVariable("id") Long id) {
        return this.filmService.getFilmById(id);
    }

    @PutMapping("/{id}")
    public FilmResponse updateFilm(@PathVariable("id") Long id, @Valid @RequestBody FilmRequest filmRequest) {
        return this.filmService.updateFilm(id, filmRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilm(@PathVariable("id") Long id) {
        this.filmService.deleteFilm(id);
    }
}
