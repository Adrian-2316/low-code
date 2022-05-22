package com.project.lowcode.content.json.domain.models;

import com.project.lowcode.shared.Type;
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
