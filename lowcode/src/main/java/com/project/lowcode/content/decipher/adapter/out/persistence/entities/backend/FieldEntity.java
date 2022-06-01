package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import com.project.lowcode.shared.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor

@NoArgsConstructor
public class FieldEntity {
    private String name;
    private Integer precision;
    private Integer scale;
    private String defaultValue;
    private Integer length;
    private Boolean nullable;
    private Boolean unique;
    private Boolean autoIncrement;
    private Boolean primaryKey;
    private Boolean foreignKey;
    private Type type;
}
