package ug.edu.pl.javaee.project.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AlphanumericValidator implements ConstraintValidator<AlphanumericConstraint, String> {
    @Override
    public void initialize(AlphanumericConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[a-z]+(-[a-z]+)*");
    }
}
