package com.salesianostriana.dam.TrianaTourist.repos;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.GetPoiDto;
import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {

    @Query(value = """
            select 
              *
            from POI  where category_id = :id
            """, nativeQuery = true)
    List<POI> todasCategoriasPOI(@Param("id") Long id);

    @Query(value = """
            select p.id
            from POI p LEFT JOIN ROUTE ro
            where p.name IN (
            select p.name from ROUTE_STEPS r
            where (p.id = r.STEPS_ID) and (p.id = :id)
            )
            """, nativeQuery = true)
    Long comprobarPOI(@Param("id") Long id);


}
