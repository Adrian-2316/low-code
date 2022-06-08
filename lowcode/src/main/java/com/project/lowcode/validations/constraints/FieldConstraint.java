package com.project.lowcode.validations.constraints;

import com.project.lowcode.content.decipher.domain.models.backend.Field;
import com.project.lowcode.shared.Type;
import com.project.lowcode.validations.annotations.FieldValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldConstraint implements ConstraintValidator<FieldValidator, Field> {
    @Override
    public void initialize(FieldValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    /**
     * @return boolean after check if fields params are valid for the field type
     */
    @Override
    public boolean isValid(Field field, ConstraintValidatorContext constraintValidatorContext) {
        if (constraintValidatorContext != null) {
            if (checkTypeString(field)) return false;
            if (checkTypeInteger(field)) return false;
            if (checkTypeBoolean(field)) return false;
            if (checkTypeDouble(field)) return false;
            if (checkTypeDate(field)) return false;
            if (checkTypeList(field)) return false;
        }
        return true;
    }

    /**
     * @param field
     * @return boolean depending on if field type List params are valid
     */
    private boolean checkTypeList(Field field) {
        if (field.getType() == Type.List
                && ((field.getAutoIncrement() != null)
                || (field.getPrimaryKey() == true)
                || (field.getDefaultValue() != null))) {
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @return boolean depending on if field type Date params are valid
     */
    private boolean checkTypeDate(Field field) {
        if (field.getType() == Type.Date
                && ((field.getLength() != null)
                || (field.getScale() != null)
                || (field.getTable() != null)
                || (field.getAutoIncrement() != null))) {
            return false;
        }
        return true;
    }

    /**
     * @param field
     * @return boolean depending on if field type Boolean params are valid
     */
    private boolean checkTypeBoolean(Field field) {
        if (field.getType().equals(Type.Boolean)
                && ((field.getLength() != null)
                || (field.getScale() != null)
                || (field.getPrecision() != null)
                || (field.getAutoIncrement() != null)
                || (field.getTable() != null)
                || (field.getDefaultValue() != null))) {
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @return boolean depending on if field type Integer params are valid
     */
    private boolean checkTypeInteger(Field field) {
        if (field.getType().equals(Type.Integer)
                && ((field.getLength() != null)
                || (field.getScale() != null)
                || (field.getPrecision() != null))) {
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @return boolean depending on if field type List params are valid
     */
    private boolean checkTypeDouble(Field field) {
        if (field.getType().equals(Type.Double)
                && ((field.getLength() != null)
                || (field.getScale() != null)
                || (field.getPrecision() != null))) {
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @return boolean depending on if field type String params are valid
     */
    private boolean checkTypeString(Field field) {
        if (field.getType().equals(Type.String) && ((field.getAutoIncrement() != null)
                || (field.getScale() != null)
                || (field.getPrecision() != null))) {
            return true;
        }
        return false;
    }
}
