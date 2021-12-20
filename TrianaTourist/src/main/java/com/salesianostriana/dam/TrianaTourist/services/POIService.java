package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.poiDto.GetPoiDto;
import com.salesianostriana.dam.TrianaTourist.dto.poiDto.POIDtoConverter;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;
    private final CategoryService categoryService;
    private final POIDtoConverter poiDtoConverter;

    public List<GetPoiDto> findAll() {
        List<POI> data = poiRepository.findAll();

        if (data.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            List<GetPoiDto> result =
                    data.stream()
                            .map(poiDtoConverter::poiRouteDto)
                            .collect(Collectors.toList());
            return result;
        }
    }

    public POI findById(Long id) {
        return poiRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public GetPoiDto save(CreatePOIDto p) {
        POI poi = POI.builder()
                .name(p.getName())
                .location(p.getLocation())
                .descripcion(p.getDescripcion())
                .date(p.getDate())
                .category(categoryService.findById(p.getCategory()))
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
        poiRepository.save(poi);
        return poiDtoConverter.poiRouteDto(poi);
    }

    public GetPoiDto edit(CreatePOIDto poi, Long id) {
        return poiRepository.findById(id).map(p -> {
            p.setName(poi.getName());
            p.setLocation(poi.getLocation());
            p.setDescripcion(poi.getDescripcion());
            p.setDate(poi.getDate());
            p.setCoverPhoto(poi.getCoverPhoto());
            p.setPhoto2(poi.getPhoto2());
            p.setPhoto3(poi.getPhoto3());
            p.setPhoto3(poi.getPhoto3());
            p.setCategory(categoryService.findById(poi.getCategory()));
            poiRepository.save(p);
            return poiDtoConverter.editPOI(p);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));

    }

    public void deleteById(Long id) {
        Optional<POI> poi = poiRepository.findById(id);
        if (poi.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        } else {
            poi.map(p -> {
                p.setCategory(null);
                poiRepository.save(p);
                poiRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            });
        }
    }

}
