package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;
import java.util.List;

public class ProfileDTO implements Serializable {

    private Long id;

    private String name;

    private List<SongProfileDTO> ratings;

    public ProfileDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SongProfileDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<SongProfileDTO> ratings) {
        this.ratings = ratings;
    }
}
