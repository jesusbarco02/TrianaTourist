package com.salesianostriana.dam.TrianaTourist.dto.poiDto;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class CreatePOIDto {

    private String name;
    private String location;
    private String descripcion;
    private LocalDate date;
    private Long category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
