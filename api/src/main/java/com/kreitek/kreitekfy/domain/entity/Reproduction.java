package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "reproductions")
public class Reproduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reproductionSequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

     /*  @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "song_id")
    private Long songId;*/

  /*  @Column(name = "reproductions")
    private Integer reproduction;*/

    public Reproduction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 /*   public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }*/

   /* public Integer getReproduction() {
        return reproduction;
    }

    public void setReproduction(Integer reproductions) {
        this.reproduction = reproductions;
    }*/

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
}
