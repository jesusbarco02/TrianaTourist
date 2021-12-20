package com.salesianostriana.dam.TrianaTourist.validation.simple.validations;

import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniqueCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !repositorio.existsByName(name);
    }
}
