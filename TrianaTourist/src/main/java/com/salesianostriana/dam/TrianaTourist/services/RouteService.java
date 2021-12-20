package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.routeDto.*;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.RoutePoiExist;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;

    public List<GetRouteDto> findAll(){
        List<Route> result = routeRepository.findAll();

        if (result.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else{
            return routeRepository.todasLasRutasDto();
        }
    }

    public GetRoutePOIDto findByIdRoutePOI(Long id){
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),Route.class));

        GetRoutePOIDto routeDto = routeDtoConverter.routePoiDto(route);
        return routeDto;
    }

    public Route findById (Long id){
        return routeRepository.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),Route.class));
    }

    public GetRouteDto save (CreateRouteDto r){
        Route route =routeDtoConverter.crearRoute(r);
        routeRepository.save(route);
        return routeDtoConverter.route(route);
    }

    public GetRoutePOIDto createListPoi (Long idRoute, Long idPoi){
        POI p = poiService.findById(idPoi);
        Route r = this.findById(idRoute);
        r.getSteps().stream().forEach(poi -> {
            if(poi.getId().equals(idPoi))
                throw new RoutePoiExist(idPoi.toString());
        });

        r.addToRoute(p);
        routeRepository.save(r);
        GetRoutePOIDto result = routeDtoConverter.routePoiDto(r);
        return result;
    }

    public GetRouteDto edit (CreateRouteDto route, Long id) {
        return routeRepository.findById(id).map(r -> {
            r.setName(route.getName());
            return routeDtoConverter.editRoute(r);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public void deleteById (Long id){
        Optional<Route> route = routeRepository.findById(id);
        if(route.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }


}
