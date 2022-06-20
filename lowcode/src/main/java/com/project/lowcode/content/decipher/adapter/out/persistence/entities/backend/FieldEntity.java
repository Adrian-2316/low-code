package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import com.project.lowcode.shared.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class FieldEntity {
    private String name;
    private String columnDefinition;
    private String defaultValue;
    private String table;
    private Integer precision;
    private Integer scale;
    private Integer length;
    private Boolean insertable;
    private Boolean updatable;
    private Boolean nullable;
    private Boolean unique;
    private Boolean autoIncrement;
    private Boolean primaryKey;
    private Boolean foreignKey;
    private Type type;
}
