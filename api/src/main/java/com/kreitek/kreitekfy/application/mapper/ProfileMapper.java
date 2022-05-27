package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.domain.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends EntityMapper<ProfileDTO, Profile>{
}
