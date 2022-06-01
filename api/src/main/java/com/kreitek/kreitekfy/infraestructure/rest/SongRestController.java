package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
import com.kreitek.kreitekfy.application.service.SongService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class SongRestController {
    private final SongService songService;

    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @CrossOrigin
    @GetMapping(value = "/songs", produces = "application/json")
    public ResponseEntity<Page<SongSimpleDTO>> getSongsByCriteriaPaged(@RequestParam(value = "filters", required = false)
                                                                           String filters, Pageable pageable) {
        Page<SongSimpleDTO> songs = this.songService.getSongsByCriteriaStringPaged(pageable, filters);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/songs", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SongAdminDTO> insertSong(@RequestBody SongAdminDTO songAdminDTO) {
        SongAdminDTO songSaved = this.songService.saveSong(songAdminDTO);
        return new ResponseEntity<>(songSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/songs", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SongAdminDTO> updateItem(@RequestBody SongAdminDTO songAdminDTO) {
        SongAdminDTO songUpdated = this.songService.saveSong(songAdminDTO);
        return new ResponseEntity<>(songUpdated, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/songs/{songId}")
    public ResponseEntity<?> deleteSongById(@PathVariable Long songId) {
        this.songService.deleteSong(songId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/{songId}")
    public ResponseEntity<SongAdminDTO> getSongById(@PathVariable Long songId) {
        Optional<SongAdminDTO> song = this.songService.getSongById(songId);

        if (song.isPresent()) {
            return new ResponseEntity<>(song.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/songs/news", produces = "application/json")
    public ResponseEntity<List<SongSimpleDTO>> getAllSongs() {
        List<SongSimpleDTO> songs = this.songService.getAllByDateSorted();
        return new ResponseEntity<List<SongSimpleDTO>>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/news", produces = "application/songStyleId+json")
    public ResponseEntity<List<SongSimpleDTO>> getAllSongsByStyle(@RequestParam Long styleId) {
        List<SongSimpleDTO> songs = this.songService.getAllSongsByStyleIdAndDateSorted(styleId);
        return new ResponseEntity<List<SongSimpleDTO>>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/ratings", produces = "application/json")
    public ResponseEntity<List<SongSimpleDTO>> getAllSongsByRating() {
        List<SongSimpleDTO> songs = this.songService.getAllByRating();
        return new ResponseEntity<List<SongSimpleDTO>>(songs, HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping(value = "/songs/ratings", produces = "application/songStyleId+json")
    public ResponseEntity<List<SongSimpleDTO>> getAllSongsByRatingAndStyle(@RequestParam Long styleId) {
        List<SongSimpleDTO> songs = this.songService.getAllByRatingAndStyle(styleId);
        return new ResponseEntity<List<SongSimpleDTO>>(songs, HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping(value = "/songs/reproduced", produces = "application/json")
    public ResponseEntity<List<SongSimpleDTO>> getAllmoreReproduced() {
        List<SongSimpleDTO> moreReproducedSongs = this.songService.getMoreReproducedSongs();
        return new ResponseEntity<List<SongSimpleDTO>>(moreReproducedSongs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/reproduced", produces = "application/songStyleRepId+json")
    public ResponseEntity<List<SongSimpleDTO>> getAllmoreReproducedByStyle(@RequestParam Long styleId) {
        List<SongSimpleDTO> moreReproducedSongs = this.songService.getMoreReproducedByStyle(styleId);
        return new ResponseEntity<List<SongSimpleDTO>>(moreReproducedSongs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/recommended", produces = "application/json")
    public ResponseEntity<List<SongSimpleDTO>> getAllRecommendedSongs(Long profileId) {
        List<SongSimpleDTO> recommendedSongs = this.songService.getRecommendedSongs(profileId);
        return new ResponseEntity<List<SongSimpleDTO>>(recommendedSongs, HttpStatus.OK);
    }

}
