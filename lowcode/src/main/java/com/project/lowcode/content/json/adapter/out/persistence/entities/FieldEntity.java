package com.project.lowcode.content.json.adapter.out.persistence.entities;

import com.project.lowcode.shared.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FieldEntity {
    private String name;
    private String precision;
    private String scale;
    private String defaultValue;
    private Integer length;
    private Boolean nullable;
    private Boolean unique;
    private Boolean autoIncrement;
    private Boolean primaryKey;
    private Boolean foreignKey;
    private Type type;
}
