package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SongRepository  extends JpaRepository<Song,Long>, JpaSpecificationExecutor<Song> {
    Page<Song> findAllByAlbumId(Long albumId, Pageable pageable);
    Page<Song> findAllByArtistId(Long artistId, Pageable pageable);
    Page<Song> findAllByStyleId(Long styleId, Pageable pageable);


}
