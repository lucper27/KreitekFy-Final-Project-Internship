package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.application.mapper.ProfileMapper;
import com.kreitek.kreitekfy.application.service.ProfileService;
import com.kreitek.kreitekfy.domain.entity.Profile;
import com.kreitek.kreitekfy.domain.persistence.ProfilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfilePersistence persistence;

    private final ProfileMapper mapper;

    @Autowired
    public ProfileServiceImpl(ProfilePersistence persistence, ProfileMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }


    @Override
    public List<ProfileDTO> getAllProfiles() {
       List<Profile> profiles = this.persistence.getAllProfiles();
       return this.mapper.toDto(profiles);
    }

    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {
        Profile profile = this.persistence.save(this.mapper.toEntity(profileDTO));
        return this.mapper.toDto(profile);
    }
}
