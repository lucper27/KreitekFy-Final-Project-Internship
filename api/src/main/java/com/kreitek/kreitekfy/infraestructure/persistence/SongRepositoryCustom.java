package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;

import java.util.List;

public interface SongRepositoryCustom {
    List<Song> findAllNewsById(Long id);
}
