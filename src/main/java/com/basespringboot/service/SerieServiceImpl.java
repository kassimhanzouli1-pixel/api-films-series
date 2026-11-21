package com.basespringboot.service;

import com.basespringboot.dto.SerieRequest;
import com.basespringboot.dto.SerieResponse;
import com.basespringboot.entity.SerieEntity;
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
public class SerieServiceImpl implements SerieService {

    private final SerieRepository serieRepository;

    @Override
    public SerieResponse createSerie(SerieRequest serieRequest) {
        SerieEntity serieEntity = new SerieEntity();
        serieEntity.setTitre(serieRequest.getTitre());
        serieEntity.setGenre(serieRequest.getGenre());
        serieEntity.setAnneeDebut(serieRequest.getAnneeDebut());
        SerieEntity savedSerie = this.serieRepository.save(serieEntity);
        return this.toResponse(savedSerie);
    }

    @Override
    public List<SerieResponse> getAllSeries() {
        List<SerieResponse> series = new ArrayList<>();
        for (SerieEntity serieEntity : this.serieRepository.findAll()) {
            series.add(this.toResponse(serieEntity));
        }
        return series;
    }

    @Override
    public SerieResponse getSerieById(Long id) {
        SerieEntity serieEntity = this.findSerie(id);
        return this.toResponse(serieEntity);
    }

    @Override
    public SerieResponse updateSerie(Long id, SerieRequest serieRequest) {
        SerieEntity serieEntity = this.findSerie(id);
        serieEntity.setTitre(serieRequest.getTitre());
        serieEntity.setGenre(serieRequest.getGenre());
        serieEntity.setAnneeDebut(serieRequest.getAnneeDebut());
        SerieEntity savedSerie = this.serieRepository.save(serieEntity);
        return this.toResponse(savedSerie);
    }

    @Override
    public void deleteSerie(Long id) {
        SerieEntity serieEntity = this.findSerie(id);
        this.serieRepository.delete(serieEntity);
    }

    private SerieEntity findSerie(Long id) {
        return this.serieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie introuvable"));
    }

    private SerieResponse toResponse(SerieEntity serieEntity) {
        return new SerieResponse(
                serieEntity.getId(),
                serieEntity.getTitre(),
                serieEntity.getGenre(),
                serieEntity.getAnneeDebut()
        );
    }
}
