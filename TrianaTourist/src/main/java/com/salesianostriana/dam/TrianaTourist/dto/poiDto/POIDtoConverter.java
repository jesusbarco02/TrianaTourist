package com.salesianostriana.dam.TrianaTourist.dto.poiDto;


import com.salesianostriana.dam.TrianaTourist.model.POI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class POIDtoConverter {

    public GetPoiDto poiRouteDto(POI poi) {
        return GetPoiDto.builder()
                .id(poi.getId())
                .name(poi.getName())
                .location(poi.getLocation())
                .descripcion(poi.getDescripcion())
                .date(poi.getDate())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .categoryId(poi.getCategory() == null ? null : poi.getCategory().getId())
                .categoryName(poi.getCategory() == null ? null : poi.getCategory().getName())
                .build();
    }

    public GetPoiDto editPOI(POI poi) {
        return GetPoiDto.builder()
                .id(poi.getId())
                .name(poi.getName())
                .location(poi.getLocation())
                .descripcion(poi.getDescripcion())
                .date(poi.getDate())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .categoryId(poi.getCategory().getId())
                .categoryName(poi.getCategory().getName())
                .build();
    }


}
