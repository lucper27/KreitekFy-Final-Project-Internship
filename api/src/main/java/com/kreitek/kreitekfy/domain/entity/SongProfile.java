package com.kreitek.kreitekfy.domain.entity;

import com.kreitek.kreitekfy.domain.key.SongProfileKey;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "profiles_songs")
public class SongProfile {

    @EmbeddedId
    private SongProfileKey id ;

    @ManyToOne
    @MapsId("songId")
    @JoinColumn(name="song_id")
    private Song song;

    @ManyToOne
    @MapsId("profileId")
    @JoinColumn(name="profile_id")
    private Profile profile;

    @Column(name = "rating")
    private Double rating;

    public SongProfileKey getId() {
        return id;
    }

    public void setId(SongProfileKey id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongProfile that = (SongProfile) o;
        return id.equals(that.id) && song.equals(that.song) && profile.equals(that.profile) && rating.equals(that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, song, profile, rating);
    }
}
