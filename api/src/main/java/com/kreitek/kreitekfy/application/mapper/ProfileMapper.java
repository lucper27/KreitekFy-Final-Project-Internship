package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.domain.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SongProfileMapper.class})
public interface ProfileMapper extends EntityMapper<ProfileDTO, Profile>{
    default Profile fromId(Long id) {
        if (id == null) return null;
        Profile profile = new Profile();
        profile.setId(id);
        return profile;
    }
}
