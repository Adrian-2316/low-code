package com.project.lowcode.content.decipher.domain.models.backend;

import com.project.lowcode.shared.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
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
