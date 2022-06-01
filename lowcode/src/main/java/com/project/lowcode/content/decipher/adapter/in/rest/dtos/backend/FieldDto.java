package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import com.project.lowcode.shared.Type;
import com.project.lowcode.validations.annotations.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto {
    private String name;
    private Integer precision;
    private Integer scale;
    private String defaultValue;
    private Integer length;
    private Boolean nullable = false;
    private Boolean unique = false;
    private Boolean autoIncrement = false;

    @EnumValidator(
            enumClazz = Type.class,
            message = "Invalid value found in entity type")
    private Type type;
}
