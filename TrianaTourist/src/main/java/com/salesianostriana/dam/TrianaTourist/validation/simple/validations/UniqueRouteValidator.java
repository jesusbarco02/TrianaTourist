package com.salesianostriana.dam.TrianaTourist.validation.simple.validations;

import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniqueRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {

    @Autowired
    private RouteRepository repositorio;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !repositorio.existsByName(name);
    }
}
