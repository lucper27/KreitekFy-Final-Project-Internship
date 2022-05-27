package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;

public class AlbumDTO implements Serializable {
    private Long id;

    private String title;

    public AlbumDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
