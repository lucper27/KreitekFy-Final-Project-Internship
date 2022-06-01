package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.ReproductionDTO;
import com.kreitek.kreitekfy.application.service.ReproductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReproductionRestController {

    private final ReproductionService reproductionService;

    @Autowired
    public ReproductionRestController(ReproductionService reproductionService) {
        this.reproductionService = reproductionService;
    }

    @CrossOrigin
    @PostMapping(value = "/songs/{songId}/reproductions", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<ReproductionDTO>> newReproduction(@PathVariable Long songId,
                                                                   @RequestBody ReproductionDTO reproductionDTO) {
        List<ReproductionDTO> reproductionDTOS = reproductionService.addReproductionToSong(songId, reproductionDTO);
        return new ResponseEntity<>(reproductionDTOS, HttpStatus.CREATED);
    }
}
