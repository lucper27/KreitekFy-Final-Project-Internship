package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.domain.entity.Reproduction;

import java.util.List;

public interface ReproductionPersistence {
    List<Reproduction> addReproductionToSong(Long songId, Reproduction reproduction);
}
