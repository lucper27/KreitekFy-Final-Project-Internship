package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.domain.entity.Reproduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, SongMapper.class})
public interface ReproductionMapper extends EntityMapper<ReproductionDTO, Reproduction>{

    @Override
    @Mapping(source = "profileId", target = "profile")
    @Mapping(target = "song", ignore = true)
    Reproduction toEntity(ReproductionDTO dto);

    @Override
    @Mapping(source = "profile.id", target = "profile")
    ReproductionDTO toDto(Reproduction entity);
}
