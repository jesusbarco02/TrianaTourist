package com.salesianostriana.dam.TrianaTourist.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoutePOI {
    @Builder.Default
    @EmbeddedId
    private RoutePOIPk id = new RoutePOIPk();

    @ManyToOne
    @MapsId("route_id")
    @JoinColumn(name="route_id")
    private Route route;

    @ManyToOne
    @MapsId("poi_id")
    @JoinColumn(name = "poi_id")
    private POI pointOfInterest;

    public void addToRoute(Route r){
        route = r;
        r.getSteps().add(this);
    }

    public void removeFromRoute(Route r){
        r.getSteps().remove(this);
        route=null;
    }

    public void addToPoi(POI p){
        pointOfInterest = p;
        if (p.getRoutes() == null){
            p.setRoutes(new ArrayList<>());
            p.getRoutes().add(this);
        }
        p.getRoutes().add(this);
    }

    public void removeFromPoi(POI p){
        p.getRoutes().remove(this);
        pointOfInterest=null;
    }
}
