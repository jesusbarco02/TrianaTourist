package com.salesianostriana.dam.TrianaTourist.repos;

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
}
