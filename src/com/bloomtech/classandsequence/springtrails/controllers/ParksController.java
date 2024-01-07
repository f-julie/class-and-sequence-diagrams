package com.bloomtech.classandsequence.springtrails.controllers;

import com.bloomtech.classandsequence.springtrails.models.Park;
import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.services.ParksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parks")
public class ParksController {
    @Autowired
    ParksService parksService;

    @GetMapping(value = "")
    public ResponseEntity<?> getParks() {
        List<Park> parks = parksService.getAllParks();
        return new ResponseEntity<>(parks, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getParkByName(@PathVariable int id) {
        Park park = parksService.getParkById(id);
        return new ResponseEntity<>(park, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/trails")
    public ResponseEntity<?> getTrails(@PathVariable int id) {
        List<Trail> parkTrails = parksService.getTrailsByParkId(id);
        return new ResponseEntity<>(parkTrails, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}/trails")
    public ResponseEntity<?> getTrailsByParkName(@PathVariable String name) {
        List<Trail> parkTrails = parksService.getTrailsByParkName(name);
        return new ResponseEntity<>(parkTrails, HttpStatus.OK);
    }
}
