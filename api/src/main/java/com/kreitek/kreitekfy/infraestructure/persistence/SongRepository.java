package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface SongRepository  extends JpaRepository<Song,Long>, JpaSpecificationExecutor<Song>, SongRepositoryCustom {
//    Page<Song> findAllByAlbumId(Long albumId, Pageable pageable);
//    Page<Song> findAllByArtistId(Long artistId, Pageable pageable);
//    Page<Song> findAllByStyleId(Long styleId, Pageable pageable);

    @Query(value = "SELECT * FROM SONGS ORDER BY INCLUSION_DATE DESC LIMIT 5", nativeQuery = true)
    List<Song> findByDateSorted();

    List<Song> findAllNewsById(Long id);

    Song findSongById(Long id);

}
