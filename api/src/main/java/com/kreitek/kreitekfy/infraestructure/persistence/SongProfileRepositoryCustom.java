package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;

import java.util.List;

public interface SongProfileRepositoryCustom {
    List<Song> findAllSongsByRating();

    //List<Song> findAllSongsByRatingAndStyleId(Long id);
}
