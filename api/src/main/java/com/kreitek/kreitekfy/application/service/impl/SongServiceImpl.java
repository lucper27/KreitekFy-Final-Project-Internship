package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
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
    public Page<SongSimpleDTO> getAllSongs(Pageable pageable) {
        Page<Song> songPage= this.persistence.getAllSongs(pageable);
        return songPage.map(mapper::toSimpleDto);
    }

    @Override
    public Page<SongSimpleDTO> getAllSongsByAlbum(Pageable pageable,Long albumId) {
        Page<Song> songPage= this.persistence.getAllSongsByAlbum(pageable, albumId);
        return songPage.map(mapper::toSimpleDto);
    }

    @Override
    public Page<SongSimpleDTO> getAllSongsByArtist(Pageable pageable, Long artistId) {
        Page<Song> songPage= this.persistence.getAllSongsByArtist(pageable, artistId);
        return songPage.map(mapper::toSimpleDto);
    }

    @Override
    public Page<SongSimpleDTO> getAllSongsByStyle(Pageable pageable,Long styleId) {
        Page<Song> songPage = this.persistence.getAllSongsByStyle(pageable, styleId);
        return songPage.map(mapper::toSimpleDto);
    }

    @Override
    public Optional<SongAdminDTO> getSongById(Long songId) {
        return this.persistence.getSongById(songId).map(mapper::toDto);
    }

    @Override
    public SongAdminDTO saveSong(SongAdminDTO songAdminDTO) {
        Song songSaved = this.persistence.saveSong(this.mapper.toEntity(songAdminDTO));
        return this.mapper.toDto(songSaved);
    }

    @Override
    public void deleteSong(Long songId) {
        this.persistence.deleteSong(songId);
    }


}
