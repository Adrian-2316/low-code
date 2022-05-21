package com.project.lowcode.content.json.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
