package com.project.lowcode.validations.constraints;

import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import com.project.lowcode.validations.annotations.FieldValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntitiyConstraint implements ConstraintValidator<FieldValidator, Entity> {
    @Override
    public void initialize(FieldValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Entity entity, ConstraintValidatorContext constraintValidatorContext) {
        return checkEntityFields(entity);
    }

    private boolean checkEntityFields(Entity entity) {
        if (entity.getFields() == null || entity.getFields().isEmpty()) {
            return false;
        }
        return true;
    }
}
