package com.salesianostriana.dam.TrianaTourist.validation.simple.validations;

import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.ExistingCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingCategoryValidator implements ConstraintValidator<ExistingCategory, Long> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(ExistingCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return repositorio.existsById(id) && id!=null;
    }
}
