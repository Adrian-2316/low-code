package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    private String name;
    private String type;
    private String length;
    private String precision;
    private String scale;
    private String nullable;
    private String defaultValue;
    private Boolean unique;
    private Boolean autoIncrement;
    private Boolean primaryKey;
    private Boolean foreignKey;
}
