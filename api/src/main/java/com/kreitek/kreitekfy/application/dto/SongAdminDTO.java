package com.kreitek.kreitekfy.application.dto;
import java.io.Serializable;
import java.util.Date;

public class SongAdminDTO implements Serializable {

    private Long id;

    private String name;

    private Long duration;

    private Date inclusionDate;

    private byte[] image;

    private Long albumId;

    private Long artistId;

    private Long styleId;

    public SongAdminDTO() {
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
