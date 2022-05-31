package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;

public class ReproductionDTO implements Serializable {

    private Long id;

    private Long songId;

    private Long profileId;

//    private Integer reproduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
