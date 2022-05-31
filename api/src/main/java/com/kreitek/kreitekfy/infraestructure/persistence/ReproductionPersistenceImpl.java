package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.application.service.SongService;
import com.kreitek.kreitekfy.domain.entity.Reproduction;
import com.kreitek.kreitekfy.domain.persistence.ReproductionPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReproductionPersistenceImpl implements ReproductionPersistence {

    private final ReproductionRepository reproductionRepository;

    private final SongService songService;

    public ReproductionPersistenceImpl(ReproductionRepository reproductionRepository, SongService songService) {
        this.reproductionRepository = reproductionRepository;
        this.songService = songService;
    }


    //for test
    @Override
    public List<ReproductionDTO> findAllBySong_id(Long songId) {
        return null;
    }

    @Override
    public List<ReproductionDTO> addReproductionToSong(Long songId, ReproductionDTO reproductionDTO) {
        return null;

    }
}
