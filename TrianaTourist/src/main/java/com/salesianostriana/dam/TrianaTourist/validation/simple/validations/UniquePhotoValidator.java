package com.salesianostriana.dam.TrianaTourist.validation.simple.validations;

import com.salesianostriana.dam.TrianaTourist.validation.simple.annotations.UniquePhoto;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhotoValidator implements ConstraintValidator<UniquePhoto, Object>{

    private String coverPhotoField;
    private String photo2Field;
    private String photo3Field;


    @Override
    public void initialize(UniquePhoto constraintAnnotation) {
        coverPhotoField = constraintAnnotation.coverPhotoField();
        photo2Field = constraintAnnotation.photo2Field();
        photo3Field = constraintAnnotation.photo3Field();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        String coverPhoto = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(coverPhotoField);
        String photo2 = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo2Field);
        String photo3 = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo3Field);

        if(coverPhoto.equals(photo2) || coverPhoto.equals(photo3) || photo2.equals(photo3)){
            return false;
        }else {
            if (photo2 == null){
                return !coverPhoto.equals(photo3);
            }
            if(photo3 == null){
                return !coverPhoto.equals(photo2);
            }
        }






    }
}
