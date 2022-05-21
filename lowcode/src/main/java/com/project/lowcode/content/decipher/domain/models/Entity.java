package com.project.lowcode.content.decipher.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
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
