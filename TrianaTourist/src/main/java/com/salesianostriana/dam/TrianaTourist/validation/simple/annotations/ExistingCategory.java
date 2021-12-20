package com.salesianostriana.dam.TrianaTourist.validation.simple.annotations;

import com.salesianostriana.dam.TrianaTourist.validation.simple.validations.ExistingCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingCategoryValidator.class)
@Documented
public @interface ExistingCategory {

    String message() default "La categoría asociada debe de existir";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
