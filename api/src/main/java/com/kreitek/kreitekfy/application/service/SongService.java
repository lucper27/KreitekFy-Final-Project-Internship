package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SongService {
    Page<SongAdminDTO> getAllSongs(Pageable pageable);
    Page<SongAdminDTO> getAllSongsByAlbum(Pageable pageable,Long albumId);
    Page<SongAdminDTO> getAllSongsByArtist(Pageable pageable,Long artistId);
    Page<SongAdminDTO> getAllSongsByStyle(Pageable pageable,Long styleId);
    Optional<SongAdminDTO> getSongById(Long songId);
    SongAdminDTO saveSong(SongAdminDTO songAdminDTO);
    void deleteSong(Long songId);
//    Page<SongAdminDTO> getSongsByCriteriaStringPaged(Pageable pageable, String filter);
}
