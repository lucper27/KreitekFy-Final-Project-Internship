package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileSequence")
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100)
    private String name;

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    private List<SongProfile> ratings;

    public Profile() {
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

    public List<SongProfile> getRatings() {
        return ratings;
    }

    public void setRatings(List<SongProfile> ratings) {
        this.ratings = ratings;
    }
}
