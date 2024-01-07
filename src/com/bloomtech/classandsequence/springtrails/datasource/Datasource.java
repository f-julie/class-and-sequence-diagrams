package com.bloomtech.classandsequence.springtrails.datasource;

import com.bloomtech.classandsequence.springtrails.models.Trail;
import com.bloomtech.classandsequence.springtrails.models.Park;
import com.bloomtech.classandsequence.springtrails.models.TrailType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Datasource {
    public final List<Park> parkData = new ArrayList<>();
    public final List<Trail> trailData = new ArrayList<>();

    public Datasource() {
        Park park1 = new Park("Mountain Park", "Colorado, USA");
        Park park2 = new Park("Pleasant Valley National Park", "British Columbia, Canada");

        parkData.add(park1);
        parkData.add(park2);

        Trail trail1 = new Trail("Rolling Hills Trail", TrailType.VALLEY, park2.getId());
        Trail trail2 = new Trail("Red River Trail", TrailType.MOUNTAIN, park1.getId());
        Trail trail3 = new Trail("Ripple Creek Trail", TrailType.FOREST, park2.getId());

        trailData.add(trail1);
        trailData.add(trail2);
        trailData.add(trail3);
    }
}
