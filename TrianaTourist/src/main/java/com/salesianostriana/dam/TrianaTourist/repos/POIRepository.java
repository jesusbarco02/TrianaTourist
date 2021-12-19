package com.salesianostriana.dam.TrianaTourist.repos;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.GetPoiDto;
import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {


}
