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

    public Reproduction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
