package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.application.dto.SongProfileDTO;
import com.kreitek.kreitekfy.application.mapper.ProfileMapper;
import com.kreitek.kreitekfy.application.mapper.SongProfileMapper;
import com.kreitek.kreitekfy.application.service.ProfileService;
import com.kreitek.kreitekfy.domain.entity.Profile;
import com.kreitek.kreitekfy.domain.entity.SongProfile;
import com.kreitek.kreitekfy.domain.persistence.ProfilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfilePersistence persistence;

    private final ProfileMapper mapper;

    private final SongProfileMapper songProfileMapper;

    @Autowired
    public ProfileServiceImpl(ProfilePersistence persistence, ProfileMapper mapper, SongProfileMapper songProfileMapper) {
        this.persistence = persistence;
        this.mapper = mapper;
        this.songProfileMapper = songProfileMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProfileDTO> getAllProfiles() {
       List<Profile> profiles = this.persistence.getAllProfiles();
       return this.mapper.toDto(profiles);
    }

    @Override
    @Transactional
    public ProfileDTO save(ProfileDTO profileDTO) {
        Profile profile = this.persistence.save(this.mapper.toEntity(profileDTO));
        return this.mapper.toDto(profile);
    }

    @Override
    @Transactional
    public List<SongProfileDTO> addSongInProfile(Long profileId, SongProfileDTO songProfileDTO) {

        List<SongProfile> songProfiles=this.persistence.addSongInProfile(profileId, songProfileMapper.toEntity(songProfileDTO));
        return this.songProfileMapper.toDto(songProfiles);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongProfileDTO> getSongsOfProfile(Long profileId) {
        List<SongProfile> songProfiles=this.persistence.getSongsOfProfile(profileId);
        return this.songProfileMapper.toDto(songProfiles);
    }


}
