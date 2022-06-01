package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongPlayerDTO;
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


import java.util.List;
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
    public Page<SongSimpleDTO> getSongsByCriteriaStringPaged(Pageable pageable, String filter) {
        Page<Song> songPage= this.persistence.getAllSongs(pageable, filter);
        return songPage.map(mapper::toSimpleDto);
    }
//
//    @Override
//    public Page<SongSimpleDTO> getAllSongsByAlbum(Pageable pageable,Long albumId) {
//        Page<Song> songPage= this.persistence.getAllSongsByAlbum(pageable, albumId);
//        return songPage.map(mapper::toSimpleDto);
//    }
//
//    @Override
//    public Page<SongSimpleDTO> getAllSongsByArtist(Pageable pageable, Long artistId) {
//        Page<Song> songPage= this.persistence.getAllSongsByArtist(pageable, artistId);
//        return songPage.map(mapper::toSimpleDto);
//    }
//
//    @Override
//    public Page<SongSimpleDTO> getAllSongsByStyle(Pageable pageable,Long styleId) {
//        Page<Song> songPage = this.persistence.getAllSongsByStyle(pageable, styleId);
//        return songPage.map(mapper::toSimpleDto);
//    }

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

    @Override
    public List<SongSimpleDTO> getAllByDateSorted() {
        List<Song> songsByDate = this.persistence.getAllByDateSorted();
        return this.mapper.toSimpleDto(songsByDate);
    }

    @Override
    public List<SongSimpleDTO> getAllSongsByStyleIdAndDateSorted(Long styleId) {
        List<Song> songByStyleAndDate = this.persistence.getAllSongsByStyleIdAndDateSorted(styleId);
        return this.mapper.toSimpleDto(songByStyleAndDate);
    }

    @Override
    public List<SongSimpleDTO> getAllByRating() {
        List<Song> songsByRating = this.persistence.getAllByRatingSorted();
        return this.mapper.toSimpleDto(songsByRating);
    }

    @Override
    public List<SongSimpleDTO> getAllByRatingAndStyle(Long styleId) {
        List<Song> songsByRatingAndStyleSorted = this.persistence.getAllByRatingAndStyleSorted(styleId);
        return this.mapper.toSimpleDto(songsByRatingAndStyleSorted);
    }

    @Override
    public List<SongSimpleDTO> getMoreReproducedSongs() {
        List<Song> moreReproducedSongs = this.persistence.findMoreReproduced();
        return this.mapper.toSimpleDto(moreReproducedSongs);
    }

    @Override
    public List<SongSimpleDTO> getMoreReproducedByStyle(Long styleId) {
        List<Song> moreReproducedByStyle = this.persistence.findMoreReproducedByStyle(styleId);
        return this.mapper.toSimpleDto(moreReproducedByStyle);
    }

    @Override
    public List<SongSimpleDTO> getRecommendedSongs(Long profileId) {
        List<Song> songsRecommended = this.persistence.getAllRecommendedSongs(profileId);
        return this.mapper.toSimpleDto(songsRecommended);
    }


}
