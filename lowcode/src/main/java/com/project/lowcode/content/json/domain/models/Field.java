package com.project.lowcode.content.json.domain.models;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Field {
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

    public Field(String name, String type, String length, String precision, String scale, String nullable, String defaultValue, Boolean unique, Boolean autoIncrement, Boolean primaryKey, Boolean foreignKey) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.precision = precision;
        this.scale = scale;
        this.nullable = nullable;
        this.defaultValue = defaultValue;
        this.unique = unique;
        this.autoIncrement = autoIncrement;
        this.primaryKey = primaryKey;
        this.foreignKey = foreignKey;

    }

    public Field() {
    }
}
