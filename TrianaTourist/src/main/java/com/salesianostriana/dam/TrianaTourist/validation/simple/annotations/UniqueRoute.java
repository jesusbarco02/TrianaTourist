package com.salesianostriana.dam.TrianaTourist.validation.simple.annotations;

import com.salesianostriana.dam.TrianaTourist.validation.simple.validations.UniqueRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRouteValidator.class)
@Documented
public @interface UniqueRoute {
    String message() default "El nombre de la ruta debe ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
