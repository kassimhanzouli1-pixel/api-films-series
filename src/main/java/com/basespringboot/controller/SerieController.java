package com.basespringboot.controller;

import com.basespringboot.dto.SerieRequest;
import com.basespringboot.dto.SerieResponse;
import com.basespringboot.service.SerieService;
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
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SerieResponse createSerie(@Valid @RequestBody SerieRequest serieRequest) {
        return this.serieService.createSerie(serieRequest);
    }

    @GetMapping
    public List<SerieResponse> getAllSeries() {
        return this.serieService.getAllSeries();
    }

    @GetMapping("/{id}")
    public SerieResponse getSerieById(@PathVariable("id") Long id) {
        return this.serieService.getSerieById(id);
    }

    @PutMapping("/{id}")
    public SerieResponse updateSerie(@PathVariable("id") Long id, @Valid @RequestBody SerieRequest serieRequest) {
        return this.serieService.updateSerie(id, serieRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSerie(@PathVariable("id") Long id) {
        this.serieService.deleteSerie(id);
    }
}
