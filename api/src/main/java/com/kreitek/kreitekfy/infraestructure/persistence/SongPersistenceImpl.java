package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import com.kreitek.kreitekfy.infraestructure.specs.SongSpecification;
import com.kreitek.kreitekfy.infraestructure.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
        return this.songRepository.findAll(specification, pageable);
    }
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

    @Override
    public List<Song> getAllSongsByStyleIdAndDateSorted(Long styleId) {
        List<Song> songsByStyleAndDate = this.songRepository.findAllNewsById(styleId);
        return songsByStyleAndDate;
    }

    @Override
    public List<Song> findMoreReproduced() {
        List<Song> moreReproducedSongs = this.songRepository.findMoreReproduced();
        return moreReproducedSongs;
    }

    @Override
    public List<Song> findMoreReproducedByStyle(Long styleId) {
        List<Song> moreReproducedByStyle = this.songRepository.findMoreReproducedByStyle(styleId);
        return moreReproducedByStyle;
    }

    @Override
    public List<Song> getAllByRatingSorted() {
        List<Song> songsByRating = this.songRepository.findAllSongsByRating();
        return songsByRating;
    }

    @Override
    public List<Song> getAllByRatingAndStyleSorted(Long styleId) {
        List<Song> songsByRating = this.songRepository.findAllSongsByRatingAndStyleSorted(styleId);
        return songsByRating;
    }

    @Override
    public List<Song> getAllRecommendedSongs(Long profileId) {
        List<Song> songsRecommended = this.songRepository.findAllSongsRecommended(profileId);
        return songsRecommended;
    }
}
