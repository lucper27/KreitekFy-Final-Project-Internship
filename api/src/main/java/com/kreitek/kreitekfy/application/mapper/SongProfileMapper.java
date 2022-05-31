package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongProfileDTO;
import com.kreitek.kreitekfy.domain.entity.SongProfile;
import com.kreitek.kreitekfy.domain.key.SongProfileKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, SongMapper.class})
public interface SongProfileMapper extends EntityMapper<SongProfileDTO, SongProfile>{

    @Override
    @Mapping(source = "songId", target = "song")
    @Mapping(source = "songId", target = "id.songId")
    @Mapping(source = "profileId", target = "profile")
    @Mapping(source = "profileId", target = "id.profileId")
    SongProfile toEntity(SongProfileDTO dto);


    @Override
    @Mapping(source="song.id", target="songId")
    @Mapping(source="profile.id", target="profileId")
    SongProfileDTO toDto(SongProfile entity);

    default SongProfile fromId(SongProfileKey id) {
        if (id == null) return null;
        SongProfile songProfile = new SongProfile();
        songProfile.setId(id);
        return songProfile;
    }
}
