package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.application.mapper.ReproductionMapper;
import com.kreitek.kreitekfy.application.service.ReproductionService;
import com.kreitek.kreitekfy.domain.entity.Reproduction;
import com.kreitek.kreitekfy.domain.persistence.ReproductionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReproductionServiceImpl implements ReproductionService {

    private final ReproductionPersistence persistence;

    private final ReproductionMapper mapper;

    @Autowired
    public ReproductionServiceImpl(ReproductionPersistence persistence, ReproductionMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<ReproductionDTO> addReproductionToSong(Long songId, ReproductionDTO reproductionDTO) {
       List<Reproduction> reproduction = this.persistence.addReproductionToSong(songId, mapper.toEntity(reproductionDTO));
       return mapper.toDto(reproduction);
    }
}
