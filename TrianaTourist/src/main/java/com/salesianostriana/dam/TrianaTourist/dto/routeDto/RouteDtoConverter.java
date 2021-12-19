package com.salesianostriana.dam.TrianaTourist.dto.routeDto;


import com.salesianostriana.dam.TrianaTourist.dto.poiDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.poiDto.GetPoiDto;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RouteDtoConverter {

    public Route crearRoute(CreateRouteDto route){
        return new Route(
                route.getName()
        );
    }

    public GetRouteDto editRoute(Route route){
        return GetRouteDto.builder()
                .id(route.getId())
                .name(route.getName())
                .build();
    }

    public GetRouteDto route (Route route){
        return GetRouteDto.builder()
                .id(route.getId())
                .name(route.getName())
                .build();
    }

    public GetRoutePOIDto routePoiDto(Route routePoiDto){
        return GetRoutePOIDto.builder()
                .id(routePoiDto.getId())
                .name(routePoiDto.getName())
                .steps(routePoiDto.getSteps().stream().map(p -> new GetPoiDto(p.getPointOfInterest().getId(),
                        p.getPointOfInterest().getName(),p.getPointOfInterest().getLocation(),
                        p.getPointOfInterest().getDescripcion(),p.getPointOfInterest().getDate(),
                        p.getPointOfInterest().getCoverPhoto(), p.getPointOfInterest().getPhoto2(),
                        p.getPointOfInterest().getPhoto3(),p.getPointOfInterest().getCategory().getId(),
                        p.getPointOfInterest().getCategory().getName())).collect(Collectors.toList()))
                .build();
    }



}
