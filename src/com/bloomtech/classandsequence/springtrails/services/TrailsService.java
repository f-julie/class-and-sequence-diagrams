package com.bloomtech.classandsequence.springtrails.services;

import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.models.TrailType;
import com.bloomtech.classandsequence.springtrails.repositories.TrailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "trailService")
public class TrailsService {
    @Autowired
    private TrailsRepository trailsRepository;

    public List<Trail> getTrails() { return trailsRepository.findAll(); }

    public Trail getTrailById(int id) {
        Trail trail = trailsRepository.findById(id).orElseThrow(()->
                new RuntimeException("No Trail found with id: " + id)
        );
        return trail;
    }

    public Trail getTrailByName(String trailName) {
        Trail trail =  trailsRepository.findByName(trailName)
                .orElseThrow(()->
                        new RuntimeException("No Trail found with name: " + trailName)
                );
        return trail;
    }

    public List<Trail> getTrailsByTrailType(TrailType trailType) {
        return trailsRepository.findByType(trailType);
    }
}
