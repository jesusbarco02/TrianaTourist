package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.categoryDto.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.categoryDto.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;
    public List<Category> findAll(){
        List<Category> result = categoryRepository.findAll();

        if (result.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return result;
        }
    }

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),Category.class));
    }

    public Category save (CreateCategoryDto e){
        Category estacion = categoryDtoConverter.crearCategory(e);

        this.categoryRepository.save(estacion);

        return estacion;

    }

    public void deleteById (Long id){
        Optional<Category> estacion = categoryRepository.findById(id);
        if(estacion.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Category.class);
        }else{
            categoryRepository.deleteById(id);
        }
    }




}
