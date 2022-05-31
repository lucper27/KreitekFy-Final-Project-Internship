package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.application.dto.SongPlayerDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import com.kreitek.kreitekfy.infraestructure.specs.SongSpecification;
import com.kreitek.kreitekfy.infraestructure.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class SongPersistenceImpl implements SongPersistence {
    private final SongRepository songRepository;

    @Autowired
    public SongPersistenceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Page<Song> getAllSongs(Pageable pageable, String filters) {
        SongSpecification specification = new SongSpecification(SearchCriteriaHelper.fromFilterString(filters));
        return this.songRepository.findAll(specification,pageable);
    }
//
//    @Override
//    public Page<Song> getAllSongsByAlbum(Pageable pageable, Long albumId) {
//        return this.songRepository.findAllByAlbumId(albumId, pageable);
//    }
//
//    @Override
//    public Page<Song> getAllSongsByArtist(Pageable pageable, Long artistId) {
//        return this.songRepository.findAllByArtistId(artistId, pageable);
//    }
//
//    @Override
//    public Page<Song> getAllSongsByStyle(Pageable pageable, Long styleId) {
//        return this.songRepository.findAllByStyleId(styleId,pageable);
//    }

    @Override
    public Optional<Song> getSongById(Long songId) {
        return this.songRepository.findById(songId);
    }

    @Override
    public Song saveSong(Song song) {
        return this.songRepository.save(song);
    }

    @Override
    public void deleteSong(Long songId) {
        this.songRepository.deleteById(songId);
    }

    @Override
    public List<Song> getAllByDateSorted() {
        List<Song> songsByDate = this.songRepository.findByDateSorted();
        System.out.println(songsByDate);
        return songsByDate;
    }


}
