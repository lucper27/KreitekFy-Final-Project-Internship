package com.kreitek.kreitekfy.domain.persistence;
import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.application.dto.SongPlayerDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface SongPersistence {
    Page<Song> getAllSongs(Pageable pageable,String filter);
//    Page<Song> getAllSongsByAlbum(Pageable pageable,Long albumId);
//    Page<Song> getAllSongsByArtist(Pageable pageable,Long artistId);
//    Page<Song> getAllSongsByStyle(Pageable pageable,Long styleId);
    Optional<Song> getSongById(Long songId);
    Song saveSong(Song song);
    void deleteSong(Long songId);

    List<Song> getAllByDateSorted();

}
