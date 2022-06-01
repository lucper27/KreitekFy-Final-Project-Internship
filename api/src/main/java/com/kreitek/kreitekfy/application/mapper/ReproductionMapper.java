package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.domain.entity.Reproduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, SongMapper.class})
public interface ReproductionMapper extends EntityMapper<ReproductionDTO, Reproduction>{

    @Override
    @Mapping(source = "songId", target = "song")
    @Mapping(source = "profileId", target = "profile")
    //@Mapping(target = "song", ignore = true)
    Reproduction toEntity(ReproductionDTO dto);

    @Override
    @Mapping(source = "profile.id", target = "profileId")
    @Mapping(source = "song.id", target = "songId")
    ReproductionDTO toDto(Reproduction entity);

    default Reproduction fromId(Long id) {
        if (id == null) return null;
        Reproduction reproduction = new Reproduction();
        reproduction.setId(id);
        return reproduction;
    }
}
