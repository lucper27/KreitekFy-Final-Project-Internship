package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.mapper.SongMapper;
import com.kreitek.kreitekfy.application.service.SongService;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongPersistence persistence;
    private final SongMapper mapper;

    @Autowired
    public SongServiceImpl(SongPersistence persistence, SongMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Page<SongAdminDTO> getAllSongs(Pageable pageable) {
        Page<Song> songPage= this.persistence.getAllSongs(pageable);
        return songPage.map(mapper::toDto);
    }

    @Override
    public Page<SongAdminDTO> getAllSongsByAlbum(Pageable pageable,Long albumId) {
        Page<Song> songPage= this.persistence.getAllSongsByAlbum(pageable, albumId);
        return songPage.map(mapper::toDto);
    }

    @Override
    public Page<SongAdminDTO> getAllSongsByArtist(Pageable pageable, Long artistId) {
        Page<Song> songPage= this.persistence.getAllSongsByArtist(pageable, artistId);
        return songPage.map(mapper::toDto);
    }

    @Override
    public Page<SongAdminDTO> getAllSongsByStyle(Pageable pageable,Long styleId) {
        Page<Song> songPage = this.persistence.getAllSongsByStyle(pageable, styleId);
        return songPage.map(mapper::toDto);
    }

    @Override
    public Optional<SongAdminDTO> getSongById(Long songId) {
        return this.persistence.getSongById(songId).map(mapper::toDto);
    }

    @Override
    @Transactional
    public SongAdminDTO saveSong(SongAdminDTO songAdminDTO) {
        Song songSaved = this.persistence.saveSong(this.mapper.toEntity(songAdminDTO));
        return this.mapper.toDto(songSaved);
    }

    @Override
    public void deleteSong(Long songId) {
        this.persistence.deleteSong(songId);
    }

//    @Override
//    public Page<SongAdminDTO> getSongsByCriteriaStringPaged(Pageable pageable, String filter) {
//        Page<Song> songPage = this.persistence.findAll(pageable, filter);
//        return songPage.map(mapper::toDto);
//    }
}
