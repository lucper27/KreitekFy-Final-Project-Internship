package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
import com.kreitek.kreitekfy.application.service.SongService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class SongRestController {
    private final SongService songService;

    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @CrossOrigin
    @GetMapping(value = "/songs", produces = "application/json")
    ResponseEntity<Page<SongSimpleDTO>> getAllSongs(Pageable pageable) {
        Page<SongSimpleDTO> songs = this.songService.getAllSongs(pageable);
        return new ResponseEntity<Page<SongSimpleDTO>>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/albums/{idAlbum}/songs", produces = "application/json")
    ResponseEntity<Page<SongSimpleDTO>> getAllSongsFromAlbum(@PathVariable Long idAlbum, Pageable pageable) {
        Page<SongSimpleDTO> songs = this.songService.getAllSongsByAlbum(pageable, idAlbum);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/artists/{idArtist}/songs", produces = "application/json")
    ResponseEntity<Page<SongSimpleDTO>> getAllSongsFromArtist(@PathVariable Long idArtist, Pageable pageable) {
        Page<SongSimpleDTO> songs = this.songService.getAllSongsByArtist(pageable, idArtist);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/styles/{idStyle}/songs", produces = "application/json")
    ResponseEntity<Page<SongSimpleDTO>> getAllSongsFromStyle(@PathVariable Long idStyle, Pageable pageable) {
        Page<SongSimpleDTO> songs = this.songService.getAllSongsByAlbum(pageable, idStyle);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/songs", produces = "application/json", consumes = "application/json")
    ResponseEntity<SongAdminDTO> insertSong(@RequestBody SongAdminDTO songAdminDTO) {
        SongAdminDTO songSaved = this.songService.saveSong(songAdminDTO);
        return new ResponseEntity<>(songSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/songs", produces = "application/json", consumes = "application/json")
    ResponseEntity<SongAdminDTO> updateItem(@RequestBody SongAdminDTO songAdminDTO) {
        SongAdminDTO songUpdated = this.songService.saveSong(songAdminDTO);
        return new ResponseEntity<>(songUpdated, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/songs/{songId}")
    ResponseEntity<?> deleteSongById(@PathVariable Long songId) {
        this.songService.deleteSong(songId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/songs/{songId}")
    ResponseEntity<SongAdminDTO> getSongById(@PathVariable Long songId) {
        Optional<SongAdminDTO> song = this.songService.getSongById(songId);

        if (song.isPresent()) {
            return new ResponseEntity<>(song.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
