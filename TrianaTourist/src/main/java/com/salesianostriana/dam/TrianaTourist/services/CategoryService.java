package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.categoryDto.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.categoryDto.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;
    private final POIRepository poiRepository;

    public List<Category> findAll() {
        List<Category> result = categoryRepository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return result;
        }
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public Category save(CreateCategoryDto c) {
        Category category = categoryDtoConverter.createCategory(c);
        this.categoryRepository.save(category);
        return category;
    }

    public Category edit(CreateCategoryDto categoria, Long id) {
        return categoryRepository.findById(id).map(c -> {
            c.setName(categoria.getName());
            return categoryRepository.save(c);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));

    }

    public void deleteById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            List<POI> poi = poiRepository.todasCategoriasPOI(id);
            poi.forEach(p -> {
                p.setCategory(null);
                poiRepository.save(p);
            });
            categoryRepository.deleteById(id);
        }
    }

}
