package com.salesianostriana.dam.TrianaTourist.repos;

import com.salesianostriana.dam.TrianaTourist.model.RouteStep;
import com.salesianostriana.dam.TrianaTourist.model.RouteStepPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStepRepository extends JpaRepository<RouteStep, RouteStepPk> {
}
