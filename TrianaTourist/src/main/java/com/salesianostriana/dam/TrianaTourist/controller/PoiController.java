package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.poiDto.POIDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.routeDto.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pointOfInterest")
public class PoiController {

    private final POIService poiService;
    private final POIDtoConverter poiDtoConverter;

    @GetMapping("/")
    public List<POI> findAll(){
        return poiService.findAll();
    }

    @GetMapping("/{id}")
    public POI findById(@PathVariable Long id){
        return poiService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<POI> crear(@Valid @RequestBody CreatePOIDto poi){
        return ResponseEntity.status(HttpStatus.CREATED).body(poiService.save(poi));
    }

    @PutMapping("/{id}")
    public POI edit(@Valid @RequestBody CreatePOIDto poi, @PathVariable Long id ){
        return poiService.edit(poi,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
