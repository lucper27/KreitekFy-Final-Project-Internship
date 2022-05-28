package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumRestController {

    private final AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @CrossOrigin
    @GetMapping(value = "/albums", produces = "application/json")
    ResponseEntity<List<AlbumDTO>> getAllAlbumsbyPartialName(@RequestParam(name = "partialName", required = true) String partialName) {
        List<AlbumDTO> albums = this.albumService.getAlbumsByName(partialName);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}
