package com.salesianostriana.dam.TrianaTourist.dto.poiDto;

import com.salesianostriana.dam.TrianaTourist.dto.routeDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPoiDto  {

    private Long id;
    private String name;
    private String location;
    private String descripcion;
    private LocalDate date;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private Long categoryId;
    private String categoryName;
}
