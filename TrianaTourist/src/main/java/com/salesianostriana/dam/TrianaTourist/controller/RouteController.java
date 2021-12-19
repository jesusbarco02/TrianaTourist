package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.routeDto.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRoutePOIDto;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.services.RouteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteServices service;
    private final RouteStepService routeStepServices;

    @GetMapping("/")
    public List<GetRouteDto> findAll(){
        return service.findAll();
    }

   @GetMapping("/{id}")
    public GetRoutePOIDto findById(@PathVariable Long id){
        return service.findByIdRoutePOI(id);
    }

    @PostMapping("/")
    public ResponseEntity<Route> crear(@Valid @RequestBody CreateRouteDto route){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(route));
    }

    @PutMapping("/{id}")
    public Route edit(@Valid @RequestBody CreateRouteDto route, @PathVariable Long id ){
        return service.edit(route,id);
    }

    @PostMapping("/{idRoute}/poi/{idPoi}")
    public ResponseEntity<GetRoutePOIDto> crearListPoi(@Valid @PathVariable Long idRoute, @PathVariable Long idPoi){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createListPoi(idRoute,idPoi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}