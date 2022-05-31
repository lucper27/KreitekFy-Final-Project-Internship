package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Reproduction;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.ReproductionPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReproductionPersistenceImpl implements ReproductionPersistence {

    private final ReproductionRepository reproductionRepository;

    private final SongRepository songRepository;

    public ReproductionPersistenceImpl(ReproductionRepository reproductionRepository, SongRepository songRepository) {
        this.reproductionRepository = reproductionRepository;
        this.songRepository = songRepository;
    }


    @Override
    public List<Reproduction> findAllBySong_id(Long songId) {
        return null;
    }

    @Override
    public List<Reproduction> addReproductionToSong(Long songId, Reproduction reproduction) {
        Song song = this.songRepository.findSongById(songId);
        song.getReproductions().add(reproduction);
        this.songRepository.save(song);
        return song.getReproductions();
    }
}
