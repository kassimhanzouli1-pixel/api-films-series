package com.basespringboot.service;

import com.basespringboot.dto.FilmRequest;
import com.basespringboot.dto.FilmResponse;
import com.basespringboot.entity.FilmEntity;
import com.basespringboot.repository.FilmRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public FilmResponse createFilm(FilmRequest filmRequest) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setTitre(filmRequest.getTitre());
        filmEntity.setGenre(filmRequest.getGenre());
        filmEntity.setAnneeSortie(filmRequest.getAnneeSortie());
        filmEntity.setDureeMinutes(filmRequest.getDureeMinutes());
        FilmEntity savedFilm = this.filmRepository.save(filmEntity);
        return this.toResponse(savedFilm);
    }

    @Override
    public List<FilmResponse> getAllFilms() {
        List<FilmResponse> films = new ArrayList<>();
        for (FilmEntity filmEntity : this.filmRepository.findAll()) {
            films.add(this.toResponse(filmEntity));
        }
        return films;
    }

    @Override
    public FilmResponse getFilmById(Long id) {
        FilmEntity filmEntity = this.findFilm(id);
        return this.toResponse(filmEntity);
    }

    @Override
    public FilmResponse updateFilm(Long id, FilmRequest filmRequest) {
        FilmEntity filmEntity = this.findFilm(id);
        filmEntity.setTitre(filmRequest.getTitre());
        filmEntity.setGenre(filmRequest.getGenre());
        filmEntity.setAnneeSortie(filmRequest.getAnneeSortie());
        filmEntity.setDureeMinutes(filmRequest.getDureeMinutes());
        FilmEntity savedFilm = this.filmRepository.save(filmEntity);
        return this.toResponse(savedFilm);
    }

    @Override
    public void deleteFilm(Long id) {
        FilmEntity filmEntity = this.findFilm(id);
        this.filmRepository.delete(filmEntity);
    }

    private FilmEntity findFilm(Long id) {
        return this.filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film introuvable"));
    }

    private FilmResponse toResponse(FilmEntity filmEntity) {
        return new FilmResponse(
                filmEntity.getId(),
                filmEntity.getTitre(),
                filmEntity.getGenre(),
                filmEntity.getAnneeSortie(),
                filmEntity.getDureeMinutes()
        );
    }
}
