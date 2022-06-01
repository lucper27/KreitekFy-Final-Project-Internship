package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistRestController {

    private final ArtistService artistService;

    @Autowired
    public ArtistRestController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @CrossOrigin
    @GetMapping(value = "/artists", produces = "application/json")
    ResponseEntity<List<ArtistDTO>> getAllArtistsbyPartialName(@RequestParam(name = "partialName", required = true)
                                                               String partialName) {
        List<ArtistDTO> artists = this.artistService.getArtistsByName(partialName);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
