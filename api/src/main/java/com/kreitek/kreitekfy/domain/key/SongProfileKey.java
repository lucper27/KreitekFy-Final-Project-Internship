package com.kreitek.kreitekfy.domain.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SongProfileKey implements Serializable {

    @Column(name = "song_id")
    private Long songId;

    @Column(name = "profile_id")
    private Long profileId;

    public SongProfileKey() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongProfileKey that = (SongProfileKey) o;
        return songId.equals(that.songId) && profileId.equals(that.profileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, profileId);
    }
}
