package com.salesianostriana.dam.TrianaTourist.repos;

import com.salesianostriana.dam.TrianaTourist.model.RoutePOI;
import com.salesianostriana.dam.TrianaTourist.model.RoutePOIPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStepRepository extends JpaRepository<RoutePOI, RoutePOIPk> {
}
