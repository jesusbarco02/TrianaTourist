package com.salesianostriana.dam.TrianaTourist.validation.simple.annotations;

import com.salesianostriana.dam.TrianaTourist.validation.simple.validations.UniqueCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCategoryValidator.class)
@Documented
public @interface UniqueCategory {
    String message() default "El nombre de la categoría debe ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
