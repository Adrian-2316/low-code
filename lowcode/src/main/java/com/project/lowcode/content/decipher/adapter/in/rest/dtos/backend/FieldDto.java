package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import com.project.lowcode.shared.Type;
import com.project.lowcode.validations.annotations.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto {
    private String name;
    private String columnDefinition;
    private String defaultValue;
    private String table;
    private Integer precision;
    private Integer scale;
    private Integer length;
    private Boolean insertable = true;
    private Boolean updatable = true;
    private Boolean primaryKey = false;
    private Boolean foreignKey = false;
    private Boolean nullable = false;
    private Boolean unique = false;
    private Boolean autoIncrement = false;
    @EnumValidator(
            enumClazz = Type.class,
            message = "Invalid value found in entity type")
    private Type type;
}
