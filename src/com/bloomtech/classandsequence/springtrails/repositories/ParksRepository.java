package com.bloomtech.classandsequence.springtrails.repositories;

import com.bloomtech.classandsequence.springtrails.datasource.Datasource;
import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.models.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ParksRepository {
    @Autowired
    private Datasource datasource;

    @Autowired
    private TrailsRepository trailsRepository;

    public List<Park> findAll() {
        return datasource.parkData;
    }

    public Optional<Park> findById(int id) {
        return datasource.parkData
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public Optional<Park> findByName(String name) {
        return datasource.parkData
                .stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }


    public List<Trail> findTrailsByParkId(int parkId) {
        return trailsRepository.findAll()
                .stream()
                .filter(trail -> trail.getParkId() == parkId)
                .collect(Collectors.toList());
    }
}
