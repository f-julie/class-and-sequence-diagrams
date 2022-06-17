package com.bloomtech.classandsequence.springtrails.controllers;

import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.models.TrailType;
import com.bloomtech.classandsequence.springtrails.services.TrailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trails")
public class TrailsController {
    @Autowired
    private TrailsService trailsService;

    @GetMapping(value = "")
    public ResponseEntity<?> getTrails() {
        List<Trail> trails = trailsService.getTrails();
        return new ResponseEntity<>(trails, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTrailById(@PathVariable int id) {
        Trail trail = trailsService.getTrailById(id);
        return new ResponseEntity<>(trail, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getTrailByName(@PathVariable String name) {
        Trail trail = trailsService.getTrailByName(name);
        return new ResponseEntity<>(trail, HttpStatus.OK);
    }

    @GetMapping(value = "/type/{trailType}")
    public ResponseEntity<?> getTrail(@PathVariable TrailType trailType) {
        List<Trail> trails = trailsService.getTrailsByTrailType(trailType);
        return new ResponseEntity<>(trails, HttpStatus.OK);
    }
}
