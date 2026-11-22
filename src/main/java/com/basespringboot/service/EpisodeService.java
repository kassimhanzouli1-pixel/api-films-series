package com.basespringboot.service;

import com.basespringboot.dto.EpisodeRequest;
import com.basespringboot.dto.EpisodeResponse;
import java.util.List;

public interface EpisodeService {

    EpisodeResponse createEpisode(EpisodeRequest episodeRequest);

    List<EpisodeResponse> getAllEpisodes();

    EpisodeResponse getEpisodeById(Long id);

    EpisodeResponse updateEpisode(Long id, EpisodeRequest episodeRequest);

    void deleteEpisode(Long id);
}