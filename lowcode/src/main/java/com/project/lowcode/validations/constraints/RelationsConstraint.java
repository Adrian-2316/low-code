package com.project.lowcode.validations.constraints;

import com.project.lowcode.content.decipher.domain.models.backend.Relations;
import com.project.lowcode.validations.annotations.RelationsValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RelationsConstraint implements ConstraintValidator<RelationsValidator, Relations> {

  @Override
  public void initialize(RelationsValidator constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(
      Relations relations, ConstraintValidatorContext constraintValidatorContext) {
    if (checkOneToOne(relations)) return false;
    if (checkOneToMany(relations)) return false;
    if (checkManyToOne(relations)) return false;
    if (checkManyToMany(relations)) return false;
    return true;
  }

  private boolean checkManyToMany(Relations relations) {
    if (relations.getRelationType().name().equals("ManyToMany")) {
      if (relations.getFirstEntity().equals(relations.getSecondEntity())) {
        return true;
      }
    }
    return false;
  }

  private boolean checkManyToOne(Relations relations) {
    if (relations.getRelationType().name().equals("ManyToOne")) {
      if (relations.getFirstEntity().equals(relations.getSecondEntity())) {
        return true;
      }
    }
    return false;
  }

  private boolean checkOneToMany(Relations relations) {
    if (relations.getRelationType().name().equals("OneToMany")) {
      if (relations.getFirstEntity().equals(relations.getSecondEntity())) {
        return true;
      }
    }
    return false;
  }

  private boolean checkOneToOne(Relations relations) {
    if (relations.getRelationType().name().equals("OneToOne")) {
      if (relations.getFirstEntity().equals(relations.getSecondEntity())) {
        return true;
      }
    }
    return false;
  }
}
