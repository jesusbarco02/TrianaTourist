package com.salesianostriana.dam.TrianaTourist.dto.categoryDto;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category crearCategory(CreateCategoryDto category){
        return new Category(
                category.getName()
        );
    }
}
