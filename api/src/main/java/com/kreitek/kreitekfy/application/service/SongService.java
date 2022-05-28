package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongService {
    Page<SongSimpleDTO> getAllSongs(Pageable pageable);
    Page<SongSimpleDTO> getAllSongsByAlbum(Pageable pageable,Long albumId);
    Page<SongSimpleDTO> getAllSongsByArtist(Pageable pageable,Long artistId);
    Page<SongSimpleDTO> getAllSongsByStyle(Pageable pageable,Long styleId);
    Optional<SongAdminDTO> getSongById(Long songId);
    SongAdminDTO saveSong(SongAdminDTO songAdminDTO);
    void deleteSong(Long songId);

    List<SongSimpleDTO> getAllByDateSorted();

}