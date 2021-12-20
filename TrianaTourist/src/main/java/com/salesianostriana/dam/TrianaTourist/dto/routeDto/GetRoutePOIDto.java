package com.salesianostriana.dam.TrianaTourist.dto.routeDto;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.GetPoiDto;
import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.ExistingCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRoutePOIDto {
    private Long id;
    private String name;
    private List<GetPoiDto> steps;
}
