package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Profile;
import com.kreitek.kreitekfy.domain.entity.SongProfile;
import com.kreitek.kreitekfy.domain.persistence.ProfilePersistence;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProfilePersistenceImpl implements ProfilePersistence {

    private final ProfileRepository profileRepository;

    public ProfilePersistenceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return this.profileRepository.findAll();
    }

    @Override
    public Profile save(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public List<SongProfile> addSongInProfile(Long profileId, SongProfile songProfile) {
        Profile profile = this.profileRepository.getProfileById(profileId);
        profile.getRatings().add(songProfile);
        this.profileRepository.save(profile);
        return profile.getRatings();
    }

    @Override
    public List<SongProfile> getSongsOfProfile(Long profileId) {
        Profile profile = this.profileRepository.getProfileById(profileId);
        return profile.getRatings();
    }
}
