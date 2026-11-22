package com.basespringboot.controller;

import com.basespringboot.dto.EpisodeRequest;
import com.basespringboot.dto.EpisodeResponse;
import com.basespringboot.service.EpisodeService;
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
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EpisodeResponse createEpisode(@Valid @RequestBody EpisodeRequest episodeRequest) {
        return this.episodeService.createEpisode(episodeRequest);
    }

    @GetMapping
    public List<EpisodeResponse> getAllEpisodes() {
        return this.episodeService.getAllEpisodes();
    }

    @GetMapping("/{id}")
    public EpisodeResponse getEpisodeById(@PathVariable("id") Long id) {
        return this.episodeService.getEpisodeById(id);
    }

    @PutMapping("/{id}")
    public EpisodeResponse updateEpisode(@PathVariable("id") Long id, @Valid @RequestBody EpisodeRequest episodeRequest) {
        return this.episodeService.updateEpisode(id, episodeRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEpisode(@PathVariable("id") Long id) {
        this.episodeService.deleteEpisode(id);
    }
}