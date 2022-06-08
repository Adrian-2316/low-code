package com.project.lowcode.validations.annotations;

import com.project.lowcode.validations.constraints.EnumConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface RelationsValidator {

  String message() default "Relation is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
