package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {

    List<ProfileDTO> getAllProfiles();

    ProfileDTO save(ProfileDTO profileDTO);
}
