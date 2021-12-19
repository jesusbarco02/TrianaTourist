package com.salesianostriana.dam.TrianaTourist.repos;

import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    boolean existsByName(String name);

    @Query("""
            select new com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto(
                r.id, r.name
            )
            from Route r 
            """)
    List<GetRouteDto> todasLasRutasDto();

}
