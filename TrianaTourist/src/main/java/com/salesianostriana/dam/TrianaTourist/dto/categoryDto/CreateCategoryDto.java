package com.salesianostriana.dam.TrianaTourist.dto.categoryDto;

import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniqueCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDto {
    @NotBlank(message = "{category.blank}")
    @UniqueCategory(message = "{category.name}")
    private String name;
}
