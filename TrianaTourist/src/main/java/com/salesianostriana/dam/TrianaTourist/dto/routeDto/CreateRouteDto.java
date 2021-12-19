package com.salesianostriana.dam.TrianaTourist.dto.routeDto;

import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniqueRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRouteDto {

    @UniqueRoute(message = "{route.name}")
    private String name;
}
