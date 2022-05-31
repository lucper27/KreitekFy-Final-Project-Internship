package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.application.dto.SongProfileDTO;

import java.util.List;

public interface ProfileService {

    List<ProfileDTO> getAllProfiles();

    ProfileDTO save(ProfileDTO profileDTO);

    List<SongProfileDTO> addSongInProfile(Long profileId, SongProfileDTO songProfileDTO);

    List<SongProfileDTO> getSongsOfProfile(Long profileId);
}
