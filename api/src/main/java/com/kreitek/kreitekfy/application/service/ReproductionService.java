package com.kreitek.kreitekfy.application.service;
import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.domain.entity.Reproduction;

import java.util.List;

public interface ReproductionService {

    List<ReproductionDTO> addReproductionToSong(Long songId, ReproductionDTO reproductionDTO);
}
