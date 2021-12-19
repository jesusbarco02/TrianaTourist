package com.salesianostriana.dam.TrianaTourist.dto.routeDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class GetRouteDto {
    private Long id;
    private String name;

}
