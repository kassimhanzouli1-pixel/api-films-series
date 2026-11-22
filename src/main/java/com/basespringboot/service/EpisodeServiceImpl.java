package com.basespringboot.service;

import com.basespringboot.dto.EpisodeRequest;
import com.basespringboot.dto.EpisodeResponse;
import com.basespringboot.entity.EpisodeEntity;
import com.basespringboot.entity.SerieEntity;
import com.basespringboot.repository.EpisodeRepository;
import com.basespringboot.repository.SerieRepository;
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
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeRepository episodeRepository;
    private final SerieRepository serieRepository;

    @Override
    public EpisodeResponse createEpisode(EpisodeRequest episodeRequest) {
        SerieEntity serieEntity = this.findSerie(episodeRequest.getSerieId());
        EpisodeEntity episodeEntity = new EpisodeEntity();
        episodeEntity.setTitre(episodeRequest.getTitre());
        episodeEntity.setNumeroSaison(episodeRequest.getNumeroSaison());
        episodeEntity.setNumeroEpisode(episodeRequest.getNumeroEpisode());
        episodeEntity.setDureeMinutes(episodeRequest.getDureeMinutes());
        episodeEntity.setSerie(serieEntity);
        EpisodeEntity savedEpisode = this.episodeRepository.save(episodeEntity);
        return this.toResponse(savedEpisode);
    }

    @Override
    public List<EpisodeResponse> getAllEpisodes() {
        List<EpisodeResponse> episodes = new ArrayList<>();
        for (EpisodeEntity episodeEntity : this.episodeRepository.findAll()) {
            episodes.add(this.toResponse(episodeEntity));
        }
        return episodes;
    }

    @Override
    public EpisodeResponse getEpisodeById(Long id) {
        EpisodeEntity episodeEntity = this.findEpisode(id);
        return this.toResponse(episodeEntity);
    }

    @Override
    public EpisodeResponse updateEpisode(Long id, EpisodeRequest episodeRequest) {
        EpisodeEntity episodeEntity = this.findEpisode(id);
        SerieEntity serieEntity = this.findSerie(episodeRequest.getSerieId());
        episodeEntity.setTitre(episodeRequest.getTitre());
        episodeEntity.setNumeroSaison(episodeRequest.getNumeroSaison());
        episodeEntity.setNumeroEpisode(episodeRequest.getNumeroEpisode());
        episodeEntity.setDureeMinutes(episodeRequest.getDureeMinutes());
        episodeEntity.setSerie(serieEntity);
        EpisodeEntity savedEpisode = this.episodeRepository.save(episodeEntity);
        return this.toResponse(savedEpisode);
    }

    @Override
    public void deleteEpisode(Long id) {
        EpisodeEntity episodeEntity = this.findEpisode(id);
        this.episodeRepository.delete(episodeEntity);
    }

    private EpisodeEntity findEpisode(Long id) {
        return this.episodeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Episode introuvable"));
    }

    private SerieEntity findSerie(Long serieId) {
        return this.serieRepository.findById(serieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie introuvable"));
    }

    private EpisodeResponse toResponse(EpisodeEntity episodeEntity) {
        return new EpisodeResponse(
                episodeEntity.getId(),
                episodeEntity.getTitre(),
                episodeEntity.getNumeroSaison(),
                episodeEntity.getNumeroEpisode(),
                episodeEntity.getDureeMinutes(),
                episodeEntity.getSerie().getId()
        );
    }
}