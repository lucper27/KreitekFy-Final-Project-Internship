package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.ProfileDTO;
import com.kreitek.kreitekfy.application.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileRestController {

    private final ProfileService profileService;

    @Autowired
    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @CrossOrigin
    @GetMapping(value = "/profiles", produces = "application/json")
    ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<ProfileDTO> profiles = this.profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/profiles", produces = "application/json", consumes = "application/json")
    ResponseEntity<ProfileDTO> createUser(@RequestBody ProfileDTO profileDTO) {
        System.out.println("Aca abajo esta el DTO");
        System.out.println(profileDTO);
        ProfileDTO savedProfile = this.profileService.save(profileDTO);
        return new ResponseEntity<>(savedProfile, HttpStatus.OK);
    }
}
