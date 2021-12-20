package com.salesianostriana.dam.TrianaTourist.dto.poiDto;

import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.ExistingCategory;
import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniquePhoto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
@UniquePhoto(coverPhotoField = "coverPhoto", photo2Field = "photo2", photo3Field = "photo3", message = "poi.uniquePhoto")
public class CreatePOIDto {
    private Long id;
    @NotBlank(message = "{poi.blank}")
    private String name;
    @Pattern(regexp ="^[-+]?([1-8]?\\d(.\\d+)?|90(.0+)?),\\s*[-+]?(180(.0+)?|((1[0-7]\\d)|([1-9]?\\d))(.\\d+)?)$"
            ,message = "{poi.ubicacion}"  )
    private String location;
    private String descripcion;
    private LocalDate date;
    @ExistingCategory(message = "poi.categoryId")
    private Long category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
