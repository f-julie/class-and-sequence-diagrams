package com.bloomtech.classandsequence.springtrails.repositories;

import com.bloomtech.classandsequence.springtrails.datasource.Datasource;
import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.models.TrailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TrailsRepository {
    @Autowired
    private Datasource datasource;

    public List<Trail> findAll() { return datasource.trailData; }

    public Optional<Trail> findByName(String name) {
        return datasource.trailData
                .stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }

    public Optional<Trail> findById(int id) {
        return datasource.trailData
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public List<Trail> findByType(TrailType trailType) {
        List<Trail> trails = datasource.trailData
                .stream()
                .filter(c -> c.getTrailType().equals(trailType))
                .collect(Collectors.toList());

        return trails;
    }
}
