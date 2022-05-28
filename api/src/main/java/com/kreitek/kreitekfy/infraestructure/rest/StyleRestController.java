package com.kreitek.kreitekfy.infraestructure.rest;

import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.application.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StyleRestController {

    private final StyleService styleService;
    @Autowired
    public StyleRestController(StyleService styleService) {
        this.styleService = styleService;
    }

    @CrossOrigin
    @GetMapping(value = "/styles", produces = "application/json")
    ResponseEntity<List<StyleDTO>> getAllStylesbyPartialName(@RequestParam(name = "partialName", required = true) String partialName) {
        List<StyleDTO> styles = this.styleService.getStylesByName(partialName);
        return new ResponseEntity<>(styles, HttpStatus.OK);
    }

}
