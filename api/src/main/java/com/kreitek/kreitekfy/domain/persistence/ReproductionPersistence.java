package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.domain.entity.Reproduction;

import java.util.List;

public interface ReproductionPersistence {

    // buscar todas las reproducciones por cancion ID, test
    List<ReproductionDTO> findAllBySong_id(Long songId);

    List<ReproductionDTO> addReproductionToSong(Long songId, ReproductionDTO reproductionDTO);
}
