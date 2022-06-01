package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Profile;
import com.kreitek.kreitekfy.domain.entity.SongProfile;
import java.util.List;

public interface ProfilePersistence {

    List<Profile> getAllProfiles();

    Profile save(Profile profile);

    List<SongProfile> addSongInProfile(Long profileId, SongProfile songProfile);

    List<SongProfile> getSongsOfProfile(Long profileId);
}
