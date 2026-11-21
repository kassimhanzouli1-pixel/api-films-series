package com.basespringboot.service;

import com.basespringboot.dto.SerieRequest;
import com.basespringboot.dto.SerieResponse;
import java.util.List;

public interface SerieService {

    SerieResponse createSerie(SerieRequest serieRequest);

    List<SerieResponse> getAllSeries();

    SerieResponse getSerieById(Long id);

    SerieResponse updateSerie(Long id, SerieRequest serieRequest);

    void deleteSerie(Long id);
}
