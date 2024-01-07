package com.bloomtech.classandsequence.springtrails.services;

import com.bloomtech.classandsequence.springtrails.models.Park;
import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.repositories.ParksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "parkService")
public class ParksService {
    @Autowired
    private ParksRepository parksRepository;

    public List<Park> getAllParks() {
        return parksRepository.findAll();
    }

    public Park getParkById(int id) {
        Park park = parksRepository.findById(id).orElseThrow(()->
                new RuntimeException("No Park found with id: " + id)
        );
        return park;
    }

    public Park getParkByName(String name) {
        Park park = parksRepository.findByName(name).orElseThrow(()->
                new RuntimeException("No Park found with name: " + name)
        );
        return park;
    }

    public List<Trail> getTrailsByParkId(int id) {
        getParkById(id);
        return parksRepository.findTrailsByParkId(id);
    }

    public List<Trail> getTrailsByParkName(String name) {
        Park park = getParkByName(name);
        return getTrailsByParkId(park.getId());
    }
}
