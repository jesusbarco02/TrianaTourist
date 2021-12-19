package com.salesianostriana.dam.TrianaTourist.dto.poiDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPoiDto  {

    private String name;
    private String location;
    private String descripcion;
    private LocalDate date;
    private String coverPhoto;
    private String photo2;
    private String photo3;


}
