package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SongProfileDTO implements Serializable {
    private Long songId;
    private Long profileId;
    private Integer rating;

    public SongProfileDTO() {
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongProfileDTO that = (SongProfileDTO) o;
        return songId.equals(that.songId) && profileId.equals(that.profileId) && rating.equals(that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, profileId, rating);
    }
}
