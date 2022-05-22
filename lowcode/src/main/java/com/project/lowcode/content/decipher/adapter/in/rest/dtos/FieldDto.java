package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import com.project.lowcode.shared.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto {
    private String name;
    private String precision;
    private String scale;
    private String defaultValue;
    private Integer length;
    private Boolean nullable = false;
    private Boolean unique;
    private Boolean autoIncrement;
    private Boolean primaryKey;
    private Boolean foreignKey;
    private Type type;
}
