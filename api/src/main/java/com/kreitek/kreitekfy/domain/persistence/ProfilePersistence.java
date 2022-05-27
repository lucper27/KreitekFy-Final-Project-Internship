package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfilePersistence {

    List<Profile> getAllProfiles();

    Profile save(Profile profile);
}
