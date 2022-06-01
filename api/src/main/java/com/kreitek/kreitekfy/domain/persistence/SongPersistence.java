package com.kreitek.kreitekfy.domain.persistence;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface SongPersistence {
    Page<Song> getAllSongs(Pageable pageable,String filter);

    Optional<Song> getSongById(Long songId);

    Song saveSong(Song song);

    void deleteSong(Long songId);

    List<Song> getAllByDateSorted();

    List<Song> getAllSongsByStyleIdAndDateSorted(Long styleId);

    List<Song> findMoreReproduced();

    List<Song> findMoreReproducedByStyle(Long styleId);

    List<Song> getAllByRatingSorted();

    List<Song> getAllByRatingAndStyleSorted(Long styleId);

    List<Song> getAllRecommendedSongs(Long profileId);
}
